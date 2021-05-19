package web.commands;

import business.entities.Carport;
import business.entities.Order;
import business.entities.materials.BillOfMaterials;
import business.exceptions.UserException;
import business.services.CarportFacade;
import business.services.OrderFacade;
import business.services.UserFacade;
import business.util.CalculateBOM;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CommandOrderHandler extends CommandProtectedPage {
    OrderFacade orderFacade;
    UserFacade userFacade;
    Order order;
    CarportFacade carportFacade;
    CarportFacade carportFacadeCheck;


    public CommandOrderHandler(String pageToShow, String role) {
        super(pageToShow, role);
        this.orderFacade = new OrderFacade(database);
        this.userFacade = new UserFacade(database);
        this.carportFacade = new CarportFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        int carportId = Integer.parseInt(request.getParameter("carportId"));
        Carport carport;
        BillOfMaterials bom;
        carport = carportFacade.getCarportById(carportId);
        if (carport.getCarportStatusId()>=2){
            request.setAttribute("error","Carporten med ID "+carportId+" er allerede oprettet som ordre i systemet.. Kontakt venligst kundeservice.");
            return "showcarportrequestpage";
        }
        bom = CalculateBOM.calculateMaterials(carport);
        int userId = carport.getUserId();
        double price = bom.getPris();
        int orderStatus = 2;
        order = new Order(carportId, userId, price, orderStatus);
        session.setAttribute("bom", bom);
        session.setAttribute("carport", carport);
        order = orderFacade.carportToOrder(order);
        session.setAttribute("orderId", order.getOrderId());
        carportFacade.updateCarportStatus(orderStatus,carportId);
        return pageToShow;
    }
}