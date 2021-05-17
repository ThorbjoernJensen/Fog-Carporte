package web.commands;

import business.entities.User;
import business.services.UserFacade;
import business.exceptions.UserException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterCommand extends CommandUnprotectedPage {
    private UserFacade userFacade;
    private CommandOrderHandler commandOrderHandler;

    public RegisterCommand(String pageToShow) {
        super(pageToShow);
        userFacade = new UserFacade(database);
        this.commandOrderHandler = new CommandOrderHandler("orderHandler", "employee");
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String tlf = request.getParameter("tlf");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        String address = request.getParameter("address");
        String zip = request.getParameter("zip");

        String creatorId = request.getParameter("creatorId");
        int tlfInt;
        try {
            tlfInt = Integer.parseInt(tlf);

        } catch (Exception e) {
            request.setAttribute("error", "Ugyldit tlf nr");
            return "registerpage";
        }

        if (password1.equals(password2)) {
            User user = userFacade.createUser(name, email, tlfInt, password1, address, zip);
            if (creatorId != null) {

                HttpSession session = request.getSession();
                session.setAttribute("name", name);
                session.setAttribute("email", email);
                session.setAttribute("user", user);
                session.setAttribute("role", user.getRole());
                session.setAttribute("address", user.getAddress());
                session.setAttribute("zip", user.getZip());
                session.setAttribute("userId", user.getUserId());

                return commandOrderHandler.execute(request, response);
            }
//            if (zip != null){
//                HttpSession session = request.getSession();
//                session.setAttribute("error", "Du har intastet et forkert postnummer eller også leveret vi ikke til dit område");
//            }


            HttpSession session = request.getSession();
            session.setAttribute("name", name);
            session.setAttribute("email", email);
            session.setAttribute("user", user);
            session.setAttribute("tlf", tlfInt);
            session.setAttribute("role", user.getRole());
            session.setAttribute("address", user.getAddress());
            session.setAttribute("zip", user.getZip());

            return user.getRole() + "page";


        } else {
            request.setAttribute("error", "the two passwords did not match");
            return "registerpage";
        }

    }
}


