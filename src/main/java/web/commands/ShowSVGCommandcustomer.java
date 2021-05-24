package web.commands;

import business.entities.Carport;
import business.entities.materials.BillOfMaterials;
import business.entities.materials.Materiale;
import business.exceptions.UserException;
import business.services.SVG;
import business.util.CalculateElementsSVG;
import business.util.CalculateElementsSVG2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowSVGCommandcustomer extends CommandProtectedPage {
    public ShowSVGCommandcustomer(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        BillOfMaterials bom;
        Carport carport;
        SVG svg;
        SVG dimensions;
        CalculateElementsSVG materialSVG = null;
        StringBuilder stringBuilder = null;

        bom = (BillOfMaterials) session.getAttribute("bom");
        carport = (Carport) session.getAttribute("carport");

        String viewBoxTemplate = "0 0 %s %s";
        String xCanvas = String.valueOf(carport.getLength()+100);
        String yCanvas = String.valueOf(carport.getWidth()+100);
        String viewBox = String.format(viewBoxTemplate, xCanvas, yCanvas);

        svg = new SVG(0, 0, viewBox, 100, 100);
        CalculateElementsSVG.calculateElements(bom, carport, svg);
        request.setAttribute("svg", svg.toString());

//        forsøg med ny stykliste
        List<Materiale> stykliste = (List<Materiale>) session.getAttribute("stykliste");
        SVG svg2 = new SVG(0, 0, viewBox, 100, 100);
        CalculateElementsSVG2.calculateElements(stykliste, carport, svg2);
        request.setAttribute("svg2", svg2.toString());







        return pageToShow;


    }

    public String getRole() {
        return role;
    }


}
