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

        int carportId = Integer.parseInt(request.getParameter("carportId"));
        int tlf = Integer.parseInt(request.getParameter("tlf"));
        double price = Double.parseDouble(request.getParameter("price"));
        int orderStatus=1;

//Skift til nu User story? her skal der oprettes en bruger, som ordren kan få sat som user_id.
        orderFacade.carportToOrder(carportId,tlf,price,orderStatus);

        return pageToShow;
    }
}