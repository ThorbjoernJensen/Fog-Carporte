package web.commands;

import business.exceptions.UserException;
import business.services.CarportFacade;
import business.services.OrderFacade;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CommandOrderHandler extends CommandProtectedPage {
    OrderFacade orderFacade;
    UserFacade userFacade;

    public CommandOrderHandler(String pageToShow, String role) {
        super(pageToShow, role);
        this.orderFacade = new OrderFacade(database);
        this.userFacade=new UserFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

//        int carportId = Integer.parseInt(request.getParameter("carportId"));
//        int userId = Integer.parseInt(request.getParameter("userId"));
//        double price = Double.parseDouble(request.getParameter("pris"));
//        int orderStatus=1;
//        System.out.println(userId);
//        orderFacade.carportToOrder(carportId,userId,price,orderStatus);
        return pageToShow;
    }
}