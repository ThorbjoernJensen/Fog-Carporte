package web.commands;

import business.exceptions.UserException;
import business.services.SVG;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowSVGCommand extends CommandProtectedPage {
    public ShowSVGCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        SVG svg = new SVG(0, 0, "0 0 800 600", 100, 50 );

        for (int x = 0; x < 14; x++)
        {
            svg.addRect(100 + 50 * x, 0, 60.0, 40.0);
        }
        request.setAttribute("svg", svg.toString());
        System.out.println(svg.toString());
        return pageToShow;

//        SVG svg = new SVG(10,10, "0 0 800 600", 100, 100);
//        svg.addRect(40,40,100,200);
//        request.setAttribute("svg", svg.toString());
//
//        return pageToShow;

    }

    public String getRole() {
        return role;
    }


}
