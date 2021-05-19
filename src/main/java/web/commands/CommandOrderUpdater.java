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

public class CommandOrderUpdater extends CommandProtectedPage {
    OrderFacade orderFacade;
    UserFacade userFacade;
    Order order;
    CarportFacade carportFacade;
    CarportFacade carportFacadeCheck;


    public CommandOrderUpdater(String pageToShow, String role) {
        super(pageToShow, role);
        this.orderFacade = new OrderFacade(database);
        this.userFacade = new UserFacade(database);
        this.carportFacade = new CarportFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        Order order;

        int orderId = 0;
        double price = 0;
        try {
            orderId = Integer.parseInt(request.getParameter("orderId"));
            if (orderId != 0) {
                price = Double.parseDouble(request.getParameter("price"));
                request.setAttribute("newPrice", price);
                orderFacade.setOrderPrice(price, orderId);
                System.out.println("vi er i try" + price);
            }
        } catch (NumberFormatException e) {

            order = (Order) session.getAttribute("order");
            price = Double.parseDouble(request.getParameter("price"));
            order.setPrice(price);
            request.setAttribute("newPrice", price);
            orderFacade.setOrderPrice(price, orderId);
            System.out.println("vi er i catch " + price);
        }


        return pageToShow;
    }
}