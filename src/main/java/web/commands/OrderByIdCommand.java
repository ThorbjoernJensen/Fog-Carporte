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


        OrderFacade orderFacade = new OrderFacade(database);
        request.getServletContext().setAttribute("orderList", orderFacade.getAllOrders());
//        request.getServletContext().setAttribute("ordreById", orderFacade.getOrderById(order.getOrderId()));


        String singleOrder = request.getParameter("singleOrder");
        String editOrder = request.getParameter("editOrder");
        String editPrice = request.getParameter("editPrice");
        String cancel = request.getParameter("cancel");
        System.out.println(editOrder + " linje 36");
        System.out.println(editPrice + " linje 37");
        if (singleOrder != null) {
            Order order = orderFacade.getOrderById((Integer.parseInt(singleOrder)));
            request.setAttribute("order", order);
            System.out.println("vi er i singleOrder");

        }
        if (cancel != null) {
            int rowsAffected = orderFacade.deleteOrder(Integer.parseInt(cancel));
            if (rowsAffected > 0) {
                request.getServletContext().setAttribute("orderList", orderFacade.getAllOrders());
                System.out.println("vi er i cancel");
            }
        }
        if (editOrder != null) {
            Order order = orderFacade.getOrderById(Integer.parseInt(editOrder));
            request.setAttribute("orderItem", order);
            System.out.println("vi er i editOrder");
            return "editorderpage";


        }
        if (editPrice != null) {
            String price = request.getParameter("price");
            String orderId= request.getParameter("order_id");
            System.out.println(price +" pris");
            System.out.println(orderId + " orderid");
            int rowsInserted = orderFacade.updateOrder(Double.parseDouble(price), Integer.parseInt(orderId));

            if (rowsInserted == 1) {
                request.getServletContext().setAttribute("orderList", orderFacade.getAllOrders());
                System.out.print("ny pris " + price + " for ordre med id = " + orderId);
                System.out.println("vi er i editPrice");
                return "showallorders";
            }

        }

        return pageToShow;
    }
}


