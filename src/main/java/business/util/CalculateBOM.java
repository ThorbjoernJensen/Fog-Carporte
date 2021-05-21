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
        double bomSamletPris;

        rem = calculateRem(carport);
        stolpe = calculateStolper(carport);
        overStern = calcultateOverstern(carport);
        spær = calculateSpær(carport);

//        ville være lettere med et interface der krævede at hver klasse havde en getSamletpris.
        bomSamletPris = stolpe.getSamletpris() + overStern.getSamletpris() + rem.getSamletpris() + spær.getSamletPris();

        return new BillOfMaterials(stolpe, overStern, rem, spær, bomSamletPris);
    }

    public static Spær calculateSpær(Carport carport) {
        Spær spær;
        int carportlenght = carport.getLength();
        int spærAntal = 0;
        int samletPris = 0;
        double centerAfstand = 0;

        int meterPris = Spær.getMeterPris();
        int maxAfstand = Spær.getMaxAfstand();
        int spærLaengde = carport.getWidth();

        spærAntal = ((carportlenght - 4) / maxAfstand) + 1;

//        antal ikke går op i længden skal vi have et spær mere så vi ikke overstiger maxafstand
        if ((carportlenght - 4) % maxAfstand > 0) {
            spærAntal = spærAntal + 1;
        }
        centerAfstand = Double.valueOf((carportlenght - 5) / (spærAntal - 1));

//        vi dividerer med 100 for at omregne for at omregne fra centimeter til meter
        samletPris = (spærAntal * spærLaengde * meterPris) / 100;

        return new Spær(spærAntal, spærLaengde, centerAfstand, samletPris);

    }

    public static Rem calculateRem(Carport carport) {
        Rem rem;
        int remLength = carport.getLength();
        int remAntal = 2;
        int meterpris = 10;
        int samletmeter;
        samletmeter = remAntal * remLength;
        int samletpris = (samletmeter * meterpris) / 100;
        rem = new Rem(remAntal, remLength, meterpris, samletpris);
        return rem;

    }

    public static Stolpe calculateStolper(Carport carport) {
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

        samletmeter = stolpeAntal * stolpeLength;
        int samletpris = (samletmeter * meterpris) / 100;
        stolpe = new Stolpe(stolpeAntal, stolpeLength, samletpris);

//        indvendigt mål sættes som højde, og vi beregner ikke ekstra til
        return stolpe;
    }

    public static Overstern calcultateOverstern(Carport carport) {
        Overstern overstern;
        int sternAntal = 2;
        int sternLængde = carport.getLength();
        int meterpris = 10;
        int samletmeter;
        samletmeter = sternAntal * sternLængde;
        int samletPris = (samletmeter * meterpris) / 100;
        overstern = new Overstern(sternAntal, sternLængde, samletPris);
        return overstern;

    }


}
