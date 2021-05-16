package web.commands;

import business.entities.Order;
import business.exceptions.UserException;
import business.services.OrderFacade;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CommandOrderHandler extends CommandProtectedPage {
    OrderFacade orderFacade;
    UserFacade userFacade;
    Order order;

    public CommandOrderHandler(String pageToShow, String role) {
        super(pageToShow, role);
        this.orderFacade = new OrderFacade(database);
        this.userFacade = new UserFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        int carportId = Integer.parseInt(request.getParameter("carportId"));
        int userId = (int) session.getAttribute("userId");
        double price = Double.parseDouble(request.getParameter("pris"));
        int orderStatus = 1;
        order = new Order(carportId, userId, price, orderStatus);
        orderFacade.carportToOrder(order);
        request.setAttribute("orderId", order.getOrderId());
        return pageToShow;
    }
}