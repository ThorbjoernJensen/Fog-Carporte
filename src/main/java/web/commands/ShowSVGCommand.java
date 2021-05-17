package web.commands;

import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowSVGCommand extends CommandProtectedPage {
    public ShowSVGCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        request.setAttribute("svgdrawing", "her bliver der tegnet");
        String svg = "<svg xmlns=\"http://www.w3.org/2000/svg\"\n" +
                "     xmlns:xlink=\"http://www.w3.org/1999/xlink\"\n" +
                "     width=\"127\" height=\"105\" viewBox=\"0 0 255 210\">\n" +
                "\n" +
                "    <rect x=\"0\" y=\"0\" height=\"200\" width=\"200\"\n" +
                "          style=\"stroke:#000000;\" stroke-width=\"2\" fill=\"white\"/>\n" +
                "    <circle cx=\"50\" cy=\"50\" r=\"50\" stroke=\"black\" stroke-width=\"2\" fill=\"white\"/>\n" +
                "    <circle cx=\"150\" cy=\"150\" r=\"50\" stroke=\"black\" stroke-width=\"2\" fill=\"white\"/>\n" +
                "    <circle cx=\"50\" cy=\"150\" r=\"50\" stroke=\"black\" stroke-width=\"2\" fill=\"white\"/>\n" +
                "    <circle cx=\"150\" cy=\"50\" r=\"50\" stroke=\"black\" stroke-width=\"2\" fill=\"white\"/>\n" +
                "</svg>";
        request.setAttribute("svg", svg);

        return pageToShow;

    }

    public String getRole() {
        return role;
    }


}
