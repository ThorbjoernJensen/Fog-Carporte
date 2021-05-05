package web.commands;

import business.exceptions.UserException;
import business.services.CarportFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CarportHandlerCommand extends CommandUnprotectedPage {
    CarportFacade carportFacade;

    public CarportHandlerCommand(String pageToShow) {
        super(pageToShow);
        this.carportFacade = new CarportFacade(database);


    }

    @Override
    public String execute(
            HttpServletRequest request,
            HttpServletResponse response) throws UserException {

        HttpSession session = request.getSession();

        int height = Integer.parseInt(request.getParameter("height"));

        carportFacade.insertHeight(height);

        session.setAttribute("height", height);

        return pageToShow;
    }
}


