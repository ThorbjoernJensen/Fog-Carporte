package web.commands;

import business.exceptions.UserException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandAdminCreateUser extends CommandProtectedPage {

    public CommandAdminCreateUser(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(
            HttpServletRequest request,
            HttpServletResponse response) throws UserException {






        return pageToShow;
    }
}