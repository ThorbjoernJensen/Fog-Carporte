package web.commands;

import business.entities.Carport;
import business.entities.materials.BillOfMaterials;
import business.exceptions.UserException;
import business.services.CarportFacade;
import business.util.CalculateBOM;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CommandShowCarportRequest extends CommandProtectedPage {

    CarportFacade carportFacade;

    public CommandShowCarportRequest(String pageToShow, String role) {
        super(pageToShow, role);
        this.carportFacade = new CarportFacade(database);

    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        Carport carport;
        BillOfMaterials bom;
        HttpSession session = request.getSession();
        carport = carportFacade.getCarportById(1);
        System.out.println("her er vores carport " + carport.toString());
        session.setAttribute("carport", carport);

        bom = CalculateBOM.calculateMaterials(carport);

        System.out.println("Her er vores mål for stolper" + bom.getStolpe().getStolpeLaengde());
        System.out.println("Her er vores længde for overstern" + bom.getOverstern().getOversternLaengde());

        session.setAttribute("bom", bom);


        return pageToShow;
    }

    public String getRole() {
        return role;
    }
}
