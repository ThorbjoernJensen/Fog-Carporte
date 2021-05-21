package web.commands;

import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandNewRequest extends CommandProtectedPage
{
    public String pageToShow;

    public CommandNewRequest(String pageToShow, String role) {
        super(pageToShow,role);
        this.pageToShow = pageToShow;
    }

    public String execute(
            HttpServletRequest request,
            HttpServletResponse response) throws UserException
    {
        return pageToShow;
    }
}