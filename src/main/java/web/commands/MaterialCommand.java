package web.commands;

import business.exceptions.UserException;
import business.services.MaterialFacede;
import javafx.scene.paint.Material;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class MaterialCommand extends CommandProtectedPage {
    MaterialFacede materialFacede;
    Material material;

    public MaterialCommand(String pageToShow, String role) {
        super(pageToShow, role);
        this.materialFacede = new MaterialFacede(database);


    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

       request.getServletContext().setAttribute("materialList", materialFacede.getAllMaterials());



     return pageToShow;
    }
}


