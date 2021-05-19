package web.commands;

import business.exceptions.UserException;
import business.services.CarportFacade;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OrderListCommand extends CommandUnprotectedPage {
    CarportFacade carportFacade;

    public OrderListCommand(String pageToShow, String role) {
        super(pageToShow);
        this.carportFacade = new CarportFacade(database);

    }

    @Override
    public String execute(
            HttpServletRequest request,
            HttpServletResponse response) throws UserException {

        HttpSession session = request.getSession();

        OrderFacade orderFacade = new OrderFacade(database);

        request.getServletContext().setAttribute("orderList", orderFacade.getAllOrders());

        return pageToShow;
    }
}


