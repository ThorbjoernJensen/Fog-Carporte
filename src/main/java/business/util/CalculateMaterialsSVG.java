package business.util;

import business.entities.Carport;
import business.entities.materials.BillOfMaterials;
import business.services.SVG;

public class CalculateMaterialsSVG {
    private BillOfMaterials bom;
    private StringBuilder svgMaterials;
    private SVG svg;

    public void CalculateMaterials(BillOfMaterials bom, Carport carport, SVG svg) {

        drawSpær(bom, carport, svg);
        drawRem(bom, carport, svg);



    }

    private void drawRem(BillOfMaterials bom, Carport carport, SVG svg) {
        double width;
        int yStart;
        int y2Start;

//        efter Foghs vejledning om 35 cm. til rem
        y2Start=35;
        y2Start= carport.getWidth()-(35+5);
        width=Double.valueOf(carport.getLength());
        svg.addRect(0, y2Start, 4.5, width);
    }


    public void drawSpær(BillOfMaterials bom, Carport carport, SVG svg) {
        double height;
        double width;
        height = Double.valueOf(carport.getWidth()-5);
        int antalSpær = bom.getSpær().getSpærAntal();
        System.out.println(antalSpær);

//        klar til at blive refaktoreret til hvis man ville ændre x til en double
        double centerafstand = (carport.getLength()-4.5)/Double.valueOf(antalSpær-1);
        int centerafstandInt = (int)Math.round(centerafstand);
            for (int x = 0; x < antalSpær; x++)
        {
            svg.addRect(centerafstandInt * x, 0, height, 4.5);
        }
    }
}
