package web.commands;

import business.entities.Carport;
import business.entities.materials.BillOfMaterials;
import business.exceptions.UserException;
import business.services.CarportFacade;
import business.util.CalculateBOM;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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
        List <Carport> carports = carportFacade.getCarportByStatusId(1);



        session.setAttribute("carport", carport);

        bom = CalculateBOM.calculateMaterials(carport);


        session.setAttribute("bom", bom);


        return pageToShow;
    }

    public String getRole() {
        return role;
    }
}
