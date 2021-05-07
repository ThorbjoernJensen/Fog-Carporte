package business.util;

import business.entities.BillOfMaterials;
import business.entities.Carport;

import java.util.List;

public class CalculateBOM {
    public static BillOfMaterials calculateMaterials(Carport carport){
        BillOfMaterials bom;

        bom = calculateStolper(carport);
        bom = calculateOverstenderForBag(carport);

        return bom;

    }

    private static BillOfMaterials calculateStolper(Carport carport) {
        BillOfMaterials bom;
        int antal = 4;
        int Længde = carport.getHeight();
        bom = new BillOfMaterials(antal, Længde);
        return bom;

    }
    private static BillOfMaterials calculateOverstenderForBag(Carport carport) {
        BillOfMaterials bom;
        int antal = 2;
        int længde = carport.getLength();
        bom = new BillOfMaterials(antal, længde);
        return bom;

    }

}
