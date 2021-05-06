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
        System.out.println(height);
        int width = Integer.parseInt(request.getParameter("width"));
        System.out.println(width);
        int length = Integer.parseInt(request.getParameter("length"));
        System.out.println(length);

        int shedwidth = Integer.parseInt(request.getParameter("shedwidth"));
        System.out.println(shedwidth);
        int shedlength = Integer.parseInt(request.getParameter("shedlength"));
        System.out.println(shedlength);

        carportFacade.insertCarport(height, width, length, shedwidth, shedlength);

        session.setAttribute("height", height);
        session.setAttribute("width", width);
        session.setAttribute("length", length);

        return pageToShow;
    }
}


