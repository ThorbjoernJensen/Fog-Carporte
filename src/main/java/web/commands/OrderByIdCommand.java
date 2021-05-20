package web.commands;

import business.entities.Order;
import business.exceptions.UserException;
import business.services.CarportFacade;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OrderByIdCommand extends CommandUnprotectedPage {
    CarportFacade carportFacade;

    public OrderByIdCommand(String pageToShow, String role) {
        super(pageToShow);
        this.carportFacade = new CarportFacade(database);

    }

    @Override
    public String execute(
            HttpServletRequest request,
            HttpServletResponse response) throws UserException {

        Order order;
        OrderFacade orderFacade = new OrderFacade(database);
        request.getServletContext().setAttribute("orderList", orderFacade.getAllOrders());
//        request.getServletContext().setAttribute("ordreById", orderFacade.getOrderById(order.getOrderId()));


        String singleOrder = request.getParameter("singleOrder");
        String editPrice = request.getParameter("editPrice");
        String cancel = request.getParameter("cancel");

        if (singleOrder != null) {
            order = orderFacade.getOrderById((Integer.parseInt(singleOrder)));
            request.setAttribute("order", order);
        } else if (cancel != null) {
            int rowsAffected = orderFacade.deleteOrder(Integer.parseInt(cancel));
            if (rowsAffected > 0) {
                request.getServletContext().setAttribute("orderList", orderFacade.getAllOrders());
            }


        }
        return pageToShow;
    }
}


