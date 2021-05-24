package web.commands;

import business.entities.Carport;
import business.exceptions.UserException;
import business.services.CarportFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CarportHandlerCommand extends CommandUnprotectedPage {
    CarportFacade carportFacade;
    CommandViewRequest commandViewRequest;

    public CarportHandlerCommand(String pageToShow) {
        super(pageToShow);
        this.carportFacade = new CarportFacade(database);
        this.commandViewRequest = new CommandViewRequest("viewrequestpage","customer");
    }

    @Override
    public String execute(
            HttpServletRequest request,
            HttpServletResponse response) throws UserException {

        HttpSession session = request.getSession();
//her sletter bruger sin ordre

        try {
            if (request.getParameter("token").equals("1")){
            return commandViewRequest.execute(request,response);
            }
            if (request.getParameter("token").equals("2")){
                String carport = request.getParameter("carportId");
                int carportId = Integer.parseInt(carport);
                carportFacade.deleteCarport(carportId);
                return commandViewRequest.execute(request,response);
            }
        } catch (UserException e) {
            request.setAttribute("error","Ordren er allerede godkendt af en medarbejder. Kontant kundeservice vedrørende annullering af ordren.");
            return "viewrequestpage";
        }


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


