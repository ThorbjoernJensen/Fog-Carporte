package business.util;

import business.entities.Carport;
import business.entities.materials.BillOfMaterials;
import business.services.SVG;

public class CalculateMaterialsSVG {
    private BillOfMaterials bom;
    private SVG svg;

    public void CalculateMaterials(BillOfMaterials bom, Carport carport, SVG svg) {
        drawSpær(bom, carport, svg);
        drawRem(bom, carport, svg);
        drawStolpe(bom, carport, svg);

    }

    private void drawStolpe(BillOfMaterials bom, Carport carport, SVG svg) {
        double width;
        double yStart;
        double y2Start;
        double stolpeWidth = 22.0;
        double indtrykning = 50.0;
        double stolpeAfstand;
        int stolpeAntal;

//        efter Foghs vejledning om 35 cm. til rem
        yStart = 35.0;
        y2Start = Double.valueOf(carport.getWidth()) - (35 + 22);
        width = Double.valueOf(carport.getLength());
        stolpeAntal = bom.getStolpe().getStolpeAntal();
        stolpeAfstand = (width - 2 * indtrykning - stolpeWidth) / (stolpeAntal / 2);
        System.out.println("afstand ml. stolper" + stolpeAfstand);

        for (int x = 0; x < (bom.getStolpe().getStolpeAntal()); x = x + 2) {

            svg.addRect(indtrykning + x * stolpeAfstand, yStart, stolpeWidth, stolpeWidth);
            svg.addRect(indtrykning + x * stolpeAfstand, y2Start, stolpeWidth, stolpeWidth);

        }
    }


    private void drawRem(BillOfMaterials bom, Carport carport, SVG svg) {
        double width;
        double yStart;
        double y2Start;

//        efter Foghs vejledning om 35 cm. til rem
        yStart = 35.0;
        y2Start = Double.valueOf(carport.getWidth()) - (35 + 5);
        width = Double.valueOf(carport.getLength());
        svg.addRect(0.0, yStart, 4.5, width);
        svg.addRect(0.0, y2Start, 4.5, width);
    }

    public void drawSpær(BillOfMaterials bom, Carport carport, SVG svg) {
        double height;
        double width;
        height = Double.valueOf(carport.getWidth() - 5);
        int antalSpær = bom.getSpær().getSpærAntal();
        System.out.println(antalSpær);

        double centerafstand = (carport.getLength() - 4.5) / Double.valueOf(antalSpær - 1);

        for (int x = 0; x < antalSpær; x++) {
            svg.addRect(centerafstand * x, 0, height, 4.5);
        }
    }
}
