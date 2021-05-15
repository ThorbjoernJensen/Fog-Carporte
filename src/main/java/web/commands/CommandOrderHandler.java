package web.commands;

import business.exceptions.UserException;
import business.services.CarportFacade;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CommandOrderHandler extends CommandProtectedPage {
    OrderFacade orderFacade;

    public CommandOrderHandler(String pageToShow, String role) {
        super(pageToShow, role);
        this.orderFacade = new OrderFacade(database);
    }

    @Override
    public String execute(
            HttpServletRequest request,
            HttpServletResponse response) throws UserException {

        HttpSession session = request.getSession();
        int carportId = Integer.parseInt(request.getParameter("carportId"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        double price = Double.parseDouble(request.getParameter("price"));
        int orderStatus=1;
        request.setAttribute("orderId", carportId);
        request.setAttribute("userId", userId);
        request.setAttribute("price", price);
        request.setAttribute("orderStatus", orderStatus);

        orderFacade.carportToOrder(carportId,userId,price,orderStatus);

        System.out.println(carportId);


        return pageToShow;
    }
}