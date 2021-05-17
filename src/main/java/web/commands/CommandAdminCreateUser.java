package web.commands;

import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CommandAdminCreateUser extends CommandProtectedPage {

    public CommandAdminCreateUser(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(
            HttpServletRequest request,
            HttpServletResponse response) throws UserException {

        HttpSession session = request.getSession();

        int carportId = Integer.parseInt(request.getParameter("carportId"));
        int roofId = Integer.parseInt(request.getParameter("roofId"));
        int height = Integer.parseInt(request.getParameter("height"));
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        int shedId = Integer.parseInt(request.getParameter("shedId"));
        int tlf = Integer.parseInt(request.getParameter("tlf"));
        int carportStatusId = Integer.parseInt(request.getParameter("carportStatusId"));

        session.setAttribute("tlf",tlf);
        session.setAttribute("carportId",carportId);

        return pageToShow;
    }
}