package business.util;

import business.entities.Carport;
import business.entities.materials.*;

import java.util.ArrayList;
import java.util.List;

public class CalculateBOM2 {
    private List<ByggeMateriale> stykliste;
    private Carport carport;

    private String materialType;
    private int antal;
    private int laengde;
    double meterPris;
    double sumMaterialPris;
    double prisStykliste;
    private double centerAfstandSpær;

    private static final int maxSpærAfstand = 60;

    public CalculateBOM2(Carport carport) {
        this.stykliste = new ArrayList<>();
        this.carport = carport;
    }

    public List<ByggeMateriale> calculateMaterials() {
        calculateStolper(carport);
        calculateRem(carport);
        calculateSpær(carport);
        calcultateOversternSider(carport);
        calcultateOversternEnder(carport);

        for (ByggeMateriale materiale : stykliste) {
            prisStykliste = prisStykliste + materiale.getSamletPris();
        }
        return stykliste;
    }

    public ByggeMateriale calculateStolper(Carport carport) {
        String materialType = "stolpe";
        meterPris = 10;

        //        stolperne graves 90 cm ned. højden sættes som den indvendige højde til spær.
        laengde = carport.getHeight() + 90;
        int carportLength = carport.getLength();

        if (carportLength > 100) {
            antal = 4;
        }
        //       vi har vurderet at man skifter til 6 stolper ved længde på over 5m
        if (carportLength > 500) {
            antal = 6;
        }
        if (carportLength > 700) {
            antal = 8;
        }

        sumMaterialPris = (antal * laengde * meterPris) / 100;

        ByggeMateriale byggeMateriale = new ByggeMateriale(materialType, antal, laengde, meterPris, sumMaterialPris);
        stykliste.add(byggeMateriale);
        return byggeMateriale;
    }

    public ByggeMateriale calculateRem(Carport carport) {
        materialType = "rem";
        antal = 2;
        meterPris = 10;
        laengde = carport.getLength();
        sumMaterialPris = Double.valueOf((antal * laengde * meterPris) / 100);

        ByggeMateriale byggeMateriale = new ByggeMateriale(materialType, antal, laengde, meterPris, sumMaterialPris);
        stykliste.add(byggeMateriale);
        return byggeMateriale;


    }

    public ByggeMateriale calculateSpær(Carport carport) {
        materialType = "spær";
        int carportlenght = carport.getLength();
        antal = ((carportlenght - 4) / maxSpærAfstand) + 1;
        laengde = carport.getWidth();
        meterPris = 10;

//        antal ikke går op i længden skal vi have et spær mere så vi ikke overstiger maxafstand
        if ((carportlenght - 4) % maxSpærAfstand > 0) {
            antal = antal + 1;
        }
        centerAfstandSpær = Double.valueOf(carportlenght - 4.5) / Double.valueOf(antal - 1);

//        vi dividerer med 100 for at omregne for at omregne fra centimeter til meter
        sumMaterialPris = (antal * laengde * meterPris) / 100;

        ByggeMateriale byggeMateriale = new ByggeMateriale(materialType, antal, laengde, meterPris, sumMaterialPris);
        stykliste.add(byggeMateriale);
        return byggeMateriale;
    }


    public ByggeMateriale calcultateOversternSider(Carport carport) {
        materialType = "overstern sider";
        antal = 2;
        laengde = carport.getLength();
        meterPris = OversternSider.getMeterPris();

        sumMaterialPris = (antal * laengde * meterPris) / 100;

        ByggeMateriale byggeMateriale = new ByggeMateriale(materialType, antal, laengde, meterPris, sumMaterialPris);
        stykliste.add(byggeMateriale);
        return byggeMateriale;

    }

    public ByggeMateriale calcultateOversternEnder(Carport carport) {
        materialType = "overstern for og bag";
        antal = 2;
        laengde = carport.getWidth();
        meterPris = 10;

        sumMaterialPris = (antal * laengde * meterPris) / 100;

        ByggeMateriale byggeMateriale = new ByggeMateriale(materialType, antal, laengde, meterPris, sumMaterialPris);
        stykliste.add(byggeMateriale);
        return byggeMateriale;

    }

    public double getPrisStykliste() {
        return prisStykliste;
    }
    public double getCenterAfstandSpær() {
        return centerAfstandSpær;
    }

}
