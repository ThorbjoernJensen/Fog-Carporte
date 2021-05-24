package web.commands;

import business.entities.Carport;
import business.entities.Order;
import business.entities.materials.BillOfMaterials;
import business.entities.materials.ByggeMateriale;
import business.exceptions.UserException;
import business.services.CarportFacade;
import business.services.OrderFacade;
import business.services.UserFacade;
import business.util.CalculateBOM;
import business.util.CalculateBOM2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CommandOrderHandler extends CommandProtectedPage {
    OrderFacade orderFacade;
    UserFacade userFacade;
    Order order;
    CarportFacade carportFacade;
    OrderListCommand orderListCommand;

    public CommandOrderHandler(String pageToShow, String role) {
        super(pageToShow, role);
        this.orderFacade = new OrderFacade(database);
        this.userFacade = new UserFacade(database);
        this.carportFacade = new CarportFacade(database);
        this.orderListCommand = new OrderListCommand("showallorders");
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();

        int carportId = Integer.parseInt(request.getParameter("carportId"));
        Carport carport;
        BillOfMaterials bom;
        carport = carportFacade.getCarportById(carportId);
        if (carport.getCarportStatusId() >= 2) {
            request.setAttribute("error", "Carporten med ID " + carportId + " er allerede oprettet som ordre i systemet.. Kontakt venligst kundeservice.");
            return "showcarportrequestpage";
        }
        bom = CalculateBOM.calculateMaterials(carport);
        int userId = carport.getUserId();
        double price = bom.getBomSamletPris();
        int orderStatus = 1;
        order = new Order(carportId, userId, price, orderStatus);

        CalculateBOM2 bom2 = new CalculateBOM2(carport);
        List<ByggeMateriale> stykliste = bom2.calculateMaterials();
        session.setAttribute("stykliste", stykliste);
        session.setAttribute("samletpris", bom2.getPrisStykliste());
        session.setAttribute("centerafstand", bom2.getCenterAfstandSpær());

        session.setAttribute("bom", bom);
        session.setAttribute("carport", carport);
        session.setAttribute("order", order);
        session.setAttribute("orderId", order.getOrderId());

        String token = request.getParameter("token");
        if (token.equals("5")) {
            double newPrice = 5;
            if (session.getAttribute("newPrice") == null) {
                orderStatus=2;
                order.setOrderStatusId(orderStatus);
                order = orderFacade.carportToOrder(order);
                carportFacade.updateCarportStatus(orderStatus, carportId);
                request.setAttribute("orderId", order.getOrderId());
                return orderListCommand.execute(request, response);

            } else {
                newPrice = (double) session.getAttribute("newPrice");
                orderStatus=2;
                order.setOrderStatusId(orderStatus);
                order.setPrice(newPrice);
                order = orderFacade.carportToOrder(order);
                carportFacade.updateCarportStatus(orderStatus, carportId);
                request.setAttribute("orderId", order.getOrderId());
                session.removeAttribute("newPrice");
                return orderListCommand.execute(request, response);
            }

        }
        return pageToShow;
    }
}