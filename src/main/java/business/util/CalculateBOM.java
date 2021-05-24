package business.util;

import business.entities.materials.*;
import business.entities.Carport;

public class CalculateBOM {
    public static BillOfMaterials calculateMaterials(Carport carport) {
        BillOfMaterials bom;
        Stolpe stolpe;
        Rem rem;
        Spær spær;
        OversternSider oversternSider;
        OversternEnder oversternEnder;
        double bomSamletPris;

        stolpe = calculateStolper(carport);
        rem = calculateRem(carport);
        spær = calculateSpær(carport);
        oversternSider = calcultateOversternSider(carport);
        oversternEnder = calcultateOversternEnder(carport);

        bomSamletPris = stolpe.getSamletPris() + rem.getSamletPris() + spær.getSamletPris()+ oversternSider.getSamletPris() +
        oversternEnder.getSamletPris();

        return new BillOfMaterials(stolpe, rem, spær, oversternSider, oversternEnder, bomSamletPris);
    }

    public static Stolpe calculateStolper(Carport carport) {
        int stolpeAntal = 0;
        double stolpeSamletPris = 0;

        int stolpeLaengde = carport.getHeight() + 90;
        int carportLength = carport.getLength();
        double meterPris = Stolpe.getMeterPris();

        if (carportLength > 100) {
            stolpeAntal = 4;
        }
        if (carportLength > 500) {
            stolpeAntal = 6;
        }
        if (carportLength > 700) {
            stolpeAntal = 8;
        }

        stolpeSamletPris = (stolpeAntal * stolpeLaengde * meterPris) / 100;
        return new Stolpe(stolpeAntal, stolpeLaengde, stolpeSamletPris);

    }

    public static Rem calculateRem(Carport carport) {
        int remAntal = 2;
        int remLaengde = carport.getLength();
        double meterPris = Rem.getMeterPris();

        double RemSamletPris = Double.valueOf((remAntal * remLaengde * meterPris) / 100);

        return new Rem(remAntal, remLaengde, RemSamletPris);

    }

    public static Spær calculateSpær(Carport carport) {
        int spærAntal = 0;
        double spærSamletPris = 0;
        double centerAfstand = 0;

        int carportlenght = carport.getLength();
        int spærLaengde = carport.getWidth();
        double meterPris = Spær.getMeterPris();
        int maxAfstand = Spær.getMaxAfstand();

        spærAntal = ((carportlenght - 4) / maxAfstand) + 1;

        if ((carportlenght - 4) % maxAfstand > 0) {
            spærAntal = spærAntal + 1;
        }
        centerAfstand = Double.valueOf(carportlenght - 4.5) / Double.valueOf(spærAntal - 1);

        spærSamletPris = (spærAntal * spærLaengde * meterPris) / 100;

        return new Spær(spærAntal, spærLaengde, centerAfstand, spærSamletPris);
    }


    public static OversternSider calcultateOversternSider(Carport carport) {

        int oversternAntal = 2;
        int oversternLængde = carport.getLength();
        double meterPris = OversternSider.getMeterPris();

        double samletPris = (oversternAntal * oversternLængde * meterPris) / 100;

        return new OversternSider(oversternAntal, oversternLængde, samletPris);

    }

    public static OversternEnder calcultateOversternEnder(Carport carport) {
        int oversternAntal = 2;
        int oversternLængde = carport.getWidth();
        double meterPris = OversternSider.getMeterPris();

        double samletPris = (oversternAntal * oversternLængde * meterPris) / 100;

        return new OversternEnder(oversternAntal, oversternLængde, samletPris);

    }
}
