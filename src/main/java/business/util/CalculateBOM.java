package business.util;

import business.entities.BillOfMaterials;
import business.entities.Carport;

import java.util.List;

public class CalculateBOM {
    public static BillOfMaterials calculateMaterials(Carport carport){
        BillOfMaterials bom;

        bom = calculateStolper(carport);

        return bom;

    }

    private static BillOfMaterials calculateStolper(Carport carport) {
        BillOfMaterials bom;
        int antal = 4;
        int laengde = carport.getHeight();
        bom = new BillOfMaterials(antal, laengde);
        return bom;




    }
}
