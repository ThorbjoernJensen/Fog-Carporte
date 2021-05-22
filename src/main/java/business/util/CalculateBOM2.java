package business.util;

import business.entities.Carport;
import business.entities.materials.*;

import java.util.ArrayList;
import java.util.List;

public class CalculateBOM2 {
    private List<Materiale> stykliste;
    private Carport carport;


    public CalculateBOM2(Carport carport) {
        this.stykliste = new ArrayList<>();
        this.carport = carport;

    }

    public List<Materiale> calculateMaterials() {
        calculateStolper(carport);
        calculateRem(carport);
        calculateSpær(carport);
//        calcultateOversternSider(carport);
//        oversternEnder = calcultateOversternEnder(carport);
//
//        bomSamletPris = stolpe.getSamletPris() + rem.getSamletPris() + spær.getSamletPris()+ oversternSider.getSamletPris() +
//        oversternEnder.getSamletPris();

//        return new BillOfMaterials(stolpe, rem, spær, oversternSider, oversternEnder, bomSamletPris);
        return stykliste;
    }

    public void calculateStolper(Carport carport) {
        int stolpeAntal = 0;
        double stolpeSamletPris = 0;

        //        stolperne graves 90 cm ned. højden sættes som den indvendige højde til spær.
        int stolpeLaengde = carport.getHeight() + 90;
        int carportLength = carport.getLength();
        double meterPris = Stolpe.getMeterPris();

        if (carportLength > 100) {
            stolpeAntal = 4;
        }
        //       vi har vurderet at man skifter til 6 stolper ved længde på over 5m
        if (carportLength > 500) {
            stolpeAntal = 6;
        }
        if (carportLength > 700) {
            stolpeAntal = 8;
        }

        stolpeSamletPris = (stolpeAntal * stolpeLaengde * meterPris) / 100;
//        return new Stolpe(stolpeAntal, stolpeLaengde, stolpeSamletPris);
        stykliste.add(new Stolpe(stolpeAntal, stolpeLaengde, stolpeSamletPris));

    }

    public void calculateRem(Carport carport) {
        int remAntal = 2;
        double remSamletPris = 0;
        int remLaengde = carport.getLength();
        double meterPris = Rem.getMeterPris();

        double RemSamletPris = Double.valueOf((remAntal * remLaengde * meterPris) / 100);

//        return new Rem(remAntal, remLaengde, RemSamletPris);
        stykliste.add(new Rem(remAntal, remLaengde, RemSamletPris));
    }

    public void calculateSpær(Carport carport) {
        Spær spær;
        int spærAntal = 0;
        double spærSamletPris = 0;
        double centerAfstand = 0;

        int carportlenght = carport.getLength();
        int spærLaengde = carport.getWidth();
        double meterPris = Spær.getMeterPris();
        int maxAfstand = Spær.getMaxAfstand();

        spærAntal = ((carportlenght - 4) / maxAfstand) + 1;

//        antal ikke går op i længden skal vi have et spær mere så vi ikke overstiger maxafstand
        if ((carportlenght - 4) % maxAfstand > 0) {
            spærAntal = spærAntal + 1;
        }
        centerAfstand = Double.valueOf(carportlenght - 4.5) / Double.valueOf(spærAntal - 1);

//        vi dividerer med 100 for at omregne for at omregne fra centimeter til meter
        spærSamletPris = (spærAntal * spærLaengde * meterPris) / 100;

//        return new Spær(spærAntal, spærLaengde, centerAfstand, spærSamletPris);
        stykliste.add(new Spær(spærAntal, spærLaengde, centerAfstand, spærSamletPris));
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
