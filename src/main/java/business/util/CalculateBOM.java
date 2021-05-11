package business.util;

import business.entities.materials.*;
import business.entities.Carport;

public class CalculateBOM {
    public static BillOfMaterials calculateMaterials(Carport carport) {
        BillOfMaterials bom;
        Stolpe stolpe;
        Overstern overStern;
        Rem rem;
        Spær spær;

        rem = calculateRem(carport);
        stolpe = calculateStolper(carport);
        overStern = calcultateOverstern(carport);
        spær = calculateSpær(carport);

        bom = new BillOfMaterials(stolpe, overStern, rem, spær);
        return bom;

    }

    private static Spær calculateSpær(Carport carport) {
        Spær spær;
        int carportlenght = carport.getLength();
        int spærAntal = 0;
        int spærLaengde = carport.getWidth();
        int maxAfstand = 55;
        spærAntal = carportlenght / maxAfstand;
        if (carportlenght % maxAfstand > 0) {
            spærAntal++;
        }
        spær = new Spær(spærAntal, spærLaengde);
        return spær;

    }

    private static Rem calculateRem(Carport carport) {
        Rem rem;
        int remLength = carport.getLength();
        int remAntal = 2;
        int meterpris = 10;
        int samletmeter;
        samletmeter = remAntal * remLength;
        int samletpris = samletmeter * meterpris;
        rem = new Rem(remAntal, remLength, meterpris, samletpris);
        System.out.println("Samletpris på rem i kr:" + samletpris);
        return rem;

    }

    private static Stolpe calculateStolper(Carport carport) {
        Stolpe stolpe;
        int stolpeLength = carport.getHeight();
        int carportLength = carport.getLength();
        int stolpeAntal = 0;
        stolpeAntal = 4;
        int meterpris = 10;
        int samletmeter;
        //       vi har vurderet at man skifter til 6 stolper ved længde på over 5m
        if (carportLength > 500) {
            stolpeAntal = 6;
        }
        if (carportLength > 700) {
            stolpeAntal = 8;
        }

        samletmeter = stolpeAntal*stolpeLength;
        int samletpris = samletmeter * meterpris;
        stolpe = new Stolpe(stolpeAntal, stolpeLength, samletpris);

//        indvendigt mål sættes som højde, og vi beregner ikke ekstra til
        return stolpe;
    }

    private static Overstern calcultateOverstern(Carport carport) {
        Overstern overstern;
        int stenderAntal = 2;
        int stenderLængde = carport.getLength();
        overstern = new Overstern(stenderAntal, stenderLængde);
        return overstern;

    }


}
