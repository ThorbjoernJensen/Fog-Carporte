package business.util;

import business.entities.materials.Overstern;
import business.entities.materials.Stolpe;
import business.entities.materials.BillOfMaterials;
import business.entities.Carport;

public class CalculateBOM {
    public static BillOfMaterials calculateMaterials(Carport carport) {
        BillOfMaterials bom;
        Stolpe stolpe;
        Overstern overStern;


        stolpe = calculateStolper(carport);
        overStern = calcultateOverstern(carport);

        bom = new BillOfMaterials(stolpe, overStern);
        return bom;

    }

    private static Stolpe calculateStolper(Carport carport) {
        Stolpe stolpe;
        int stolpeLength = carport.getHeight();
        int carportLength = carport.getLength();
        int stolpeAntal = 0;
        stolpeAntal = 4;
        //       vi har vurderet at man skifter til 6 stolper ved længde på over 5m
        if (carportLength > 500) {
            stolpeAntal = 6;
        }
        if (carportLength > 700) {
            stolpeAntal = 8;
        }
        stolpe = new Stolpe(stolpeAntal, stolpeLength);

//        indvendigt mål sættes som højde, og vi beregner ikke ekstra til
        return stolpe;
    }


    private static Overstern calcultateOverstern (Carport carport) {
        Overstern overstern;
        int stenderAntal = 2;
        int stenderLængde = carport.getLength();
        overstern = new Overstern(stenderAntal, stenderLængde);
        return overstern;

    }

}
