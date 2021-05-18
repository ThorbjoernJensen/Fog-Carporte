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

        int userId = (int) session.getAttribute("userId");
        int height = Integer.parseInt(request.getParameter("height"));
        int width = Integer.parseInt(request.getParameter("width"));
        int length = Integer.parseInt(request.getParameter("length"));

        int shedwidth = Integer.parseInt(request.getParameter("shedwidth"));
        int shedlength = Integer.parseInt(request.getParameter("shedlength"));

        String roofmaterial = request.getParameter("roofmaterial");



        if (shedlength!=0 && shedwidth!=0) {
            carportFacade.insertCarportWithShed(userId, height, width, length, shedwidth, shedlength, roofmaterial);
            session.setAttribute("userId", userId);
            session.setAttribute("height", height);
            session.setAttribute("width", width);
            session.setAttribute("length", length);
            session.setAttribute("shedwidth", shedwidth);
            session.setAttribute("shedlength", shedlength);
            session.setAttribute("roofmaterial", roofmaterial);
        }

        if (shedlength==0 && shedwidth==0){
        carportFacade.insertCarportWithoutShed(userId,height,width,length,roofmaterial);
            session.setAttribute("userId", userId);
            session.setAttribute("height", height);
            session.setAttribute("width", width);
            session.setAttribute("length", length);
            session.setAttribute("roofmaterial", roofmaterial);

        }

        return pageToShow;
    }
}


