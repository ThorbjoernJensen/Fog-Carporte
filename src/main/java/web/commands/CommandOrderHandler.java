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


    public CommandOrderHandler(String pageToShow, String role) {
        super(pageToShow, role);
        this.orderFacade = new OrderFacade(database);
        this.userFacade = new UserFacade(database);
        this.carportFacade = new CarportFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        Carport carport;
        BillOfMaterials bom;
        int carportId = Integer.parseInt(request.getParameter("carportId"));
        carport = carportFacade.getCarportById(carportId);
        bom = CalculateBOM.calculateMaterials(carport);
        int userId = (int) session.getAttribute("userId");
        //Mangler at kunne sætte andre status via select menu.
        int orderStatus = 2;
        double price = bom.getPris();
        order = new Order(carportId, userId, price, orderStatus);
        session.setAttribute("bom", bom);
        session.setAttribute("carport", carport);
        request.setAttribute("orderId", order.getOrderId());
        orderFacade.carportToOrder(order, orderStatus);
        return pageToShow;
    }
}