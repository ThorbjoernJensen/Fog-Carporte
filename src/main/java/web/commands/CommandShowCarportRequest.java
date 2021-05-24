package web.commands;

import business.entities.Carport;
import business.exceptions.UserException;
import business.services.CarportFacade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CommandShowCarportRequest extends CommandProtectedPage {

    CarportFacade carportFacade;
    CommandShowCarportRequest commandShowCarportRequest;

    public CommandShowCarportRequest(String pageToShow, String role) {
        super(pageToShow, role);
        this.carportFacade = new CarportFacade(database);

    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        List <Carport> carportList = carportFacade.getCarportByStatusId(1);

        session.setAttribute("carportList", carportList);

        return pageToShow;
    }

    public String getRole() {
        return role;
    }
}
