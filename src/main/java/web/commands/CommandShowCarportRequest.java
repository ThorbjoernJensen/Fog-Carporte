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
        HttpSession session = request.getSession();
        Carport carport;
        BillOfMaterials bom;
        carport = carportFacade.getCarportById(1);

        List<Carport> carportList = carportFacade.getCarportByStatusId(1);
        System.out.println(carportList.size());


        session.setAttribute("carportList", carportList);


        session.setAttribute("carport", carport);
        System.out.println(carport.getLength() + "længde");
        session.setAttribute("carportList", carportList);

        bom = CalculateBOM.calculateMaterials(carport);
        session.setAttribute("bom", bom);
        return pageToShow;
    }

    public String getRole() {
        return role;
    }
}
