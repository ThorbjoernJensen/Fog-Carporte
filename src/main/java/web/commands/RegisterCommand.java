package web.commands;

import business.entities.User;
import business.services.UserFacade;
import business.exceptions.UserException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class RegisterCommand extends CommandUnprotectedPage {
    private UserFacade userFacade;
    CarportHandlerCommand carportHandlerCommand;


    public RegisterCommand(String pageToShow) {
        super(pageToShow);
        this.userFacade = new UserFacade(database);
        this.carportHandlerCommand = new CarportHandlerCommand("receiptpage");
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
        String returnpage="";


        int shedwidth = 0;
        int shedlength = 0;
        try {
            shedwidth = Integer.parseInt(request.getParameter("shedwidth"));
            shedlength = Integer.parseInt(request.getParameter("shedlength"));
        } catch (NumberFormatException e) {
            returnpage = "registerpage";
        }


        try {
            if (request.getParameter("creatorId").equals("1")) {
                returnpage = "index";
            }
        } catch (NullPointerException e) {
            returnpage = "registerpage";
        }

        if (email.contains("@")) {

            int tlfInt;

            try {
                tlfInt = Integer.parseInt(tlf);

            } catch (Exception e) {
                request.setAttribute("error", "Ugyldit tlf nr. Kun hele tal");
                return returnpage;
            }

            if (password1.equals(password2)) {
                if (shedlength!=0 && shedwidth==0){
                    request.setAttribute("error","Du skal vælge både længde og bredde på dit skur");
                    return returnpage;

                }
                if (shedwidth!=0 && shedlength==0){
                    request.setAttribute("error","Du skal vælge både længde og bredde på dit skur");
                    return returnpage;
                }
                User user = userFacade.createUser(name, email, tlfInt, password1, address, zip);
                HttpSession session = request.getSession();


                if (returnpage.equals("index")) {
                    session.setAttribute("userId",user.getUserId());
                    return carportHandlerCommand.execute(request, response);
                } else {

                    session.setAttribute("name", name);
                    session.setAttribute("email", email);
                    session.setAttribute("user", user);
                    session.setAttribute("tlf", tlfInt);
                    session.setAttribute("role", user.getRole());
                    session.setAttribute("address", user.getAddress());
                    session.setAttribute("zip", user.getZip());
                    session.setAttribute("userId",user.getUserId());
                    return user.getRole() + "page";
                }
            } else {
                request.setAttribute("error", "the two passwords did not match");
                return returnpage;
            }
        } else {
            request.setAttribute("error", "Ugyldit email.");
            return returnpage;
        }
    }
}
