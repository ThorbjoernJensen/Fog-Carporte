package web.commands;

import business.entities.Carport;
import business.entities.materials.BillOfMaterials;
import business.exceptions.UserException;
import business.services.SVG;
import business.util.CalculateMaterialsSVG;
import com.mysql.cj.Session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowSVGCommand extends CommandProtectedPage {
    public ShowSVGCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        BillOfMaterials bom;
        Carport carport;
        SVG svg;
        CalculateMaterialsSVG materialSVG = null;
        StringBuilder stringBuilder = null;

        bom = (BillOfMaterials) session.getAttribute("bom");
        carport = (Carport) session.getAttribute("carport");


        String viewBoxTemplate = "0 0 %s %s";

        String xCanvas = String.valueOf(carport.getLength()+100);
        String yCanvas = String.valueOf(carport.getWidth()+100);
        String viewBox = String.format(viewBoxTemplate, xCanvas, yCanvas);
        System.out.println("vores viewbox " + viewBox);

        svg = new SVG(0, 0, viewBox, 100, 50);
        materialSVG = new CalculateMaterialsSVG();
        materialSVG.CalculateMaterials(bom, carport, svg);

//        stringBuilder.append(svg);
//        stringBuilder.append(

        request.setAttribute("svg", svg.toString());

        return pageToShow;


    }

    public String getRole() {
        return role;
    }


}