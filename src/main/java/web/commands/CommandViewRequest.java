package web.commands;

import business.entities.Carport;
import business.exceptions.UserException;
import business.services.CarportFacade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CommandViewRequest extends CommandProtectedPage
{
    public String pageToShow;
    CarportFacade carportFacade;

    public CommandViewRequest(String pageToShow, String role) {
        super(pageToShow,role);
        this.pageToShow = pageToShow;
        this.carportFacade = new CarportFacade(database);
    }

    public String execute(
            HttpServletRequest request,
            HttpServletResponse response) throws UserException
    {
        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("userId");

        List<Carport> carportUserList = carportFacade.getCarportByUser(userId);
        session.setAttribute("carportUserList",carportUserList);

        return pageToShow;
    }
}