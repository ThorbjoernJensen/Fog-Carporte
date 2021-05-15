package web.commands;

import business.exceptions.UserException;
import business.services.CarportFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CommandOrderHandler extends CommandProtectedPage {

    public CommandOrderHandler(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(
            HttpServletRequest request,
            HttpServletResponse response) throws UserException {
HttpSession session = request.getSession();
String carportId=request.getParameter("carportId");
session.setAttribute("orderId",carportId);

        System.out.println(carportId);





        return pageToShow;
    }
}