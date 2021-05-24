package web.commands;

import business.entities.Carport;
import business.entities.Order;
import business.entities.materials.BillOfMaterials;
import business.exceptions.UserException;
import business.services.CarportFacade;
import business.services.OrderFacade;
import business.services.UserFacade;
import business.util.CalculateBOM;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CommandOrderHandlerCustomer extends CommandProtectedPage {

    UserFacade userFacade;
    ShowSVGCommandcustomer showSVGCommandcustomer;
    CarportFacade carportFacade;

    public CommandOrderHandlerCustomer(String pageToShow, String role) {
        super(pageToShow, role);
        this.userFacade = new UserFacade(database);
        this.carportFacade = new CarportFacade(database);
        this.showSVGCommandcustomer = new ShowSVGCommandcustomer("showsvgpage","customer");
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        int carportId = Integer.parseInt(request.getParameter("carportId"));
        Carport carport;
        BillOfMaterials bom;
        carport = carportFacade.getCarportById(carportId);
        bom = CalculateBOM.calculateMaterials(carport);
        session.setAttribute("bom", bom);
        session.setAttribute("carport", carport);
        return showSVGCommandcustomer.execute(request, response);
    }
}