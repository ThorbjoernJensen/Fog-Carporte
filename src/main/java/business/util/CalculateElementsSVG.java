package business.util;

import business.entities.Carport;
import business.entities.materials.BillOfMaterials;
import business.services.SVG;

public class CalculateElementsSVG {
    private BillOfMaterials bom;
    private SVG svg;

    public static void calculateElements(BillOfMaterials bom, Carport carport, SVG svg) {
        SVG materialSVG;


        String viewBoxTemplate = "0 0 %s %s";
        String xCanvas = String.valueOf(carport.getLength());
        System.out.println("længde som bliver til carport: "+ carport.getLength());
        String yCanvas = String.valueOf(carport.getWidth());
        String viewBox = String.format(viewBoxTemplate, xCanvas, yCanvas);

        materialSVG = new SVG(100, 10, viewBox, 100, 100);

        drawStolpe(bom, carport, materialSVG);
        drawRem(bom, carport, materialSVG);
        drawSpær(bom, carport, materialSVG);
        svg.addSvg(materialSVG);

        String xCanvasDimensions = String.valueOf(carport.getLength() + 100);
        String yCanvasSimensions = String.valueOf(carport.getWidth() + 100);
        String viewBoxDimensions = String.format(viewBoxTemplate, xCanvas, yCanvas);

        SVG dimensionsSVG = new SVG(0, 0, viewBoxDimensions, 100, 100);
        drawArrawX(bom, carport, dimensionsSVG);
        drawArrawY(bom, carport, dimensionsSVG);
        svg.addSvg(dimensionsSVG);


    }

    private static void drawArrawX(BillOfMaterials bom, Carport carport, SVG dimensionsSVG) {
        int x1;
        int y1;
        int x2;
        int y2;

        x1= 50;
        y1= 10;
        x2= x1;
        y2= y1+ carport.getWidth();
        dimensionsSVG.addDimensionXLine(x1, y1, x2, y2);
        dimensionsSVG.addArrowDefinitions();
        dimensionsSVG.addDefinitionLineText(40, carport.getWidth()/2, -90, carport.getWidth());


    }

    private static void drawArrawY(BillOfMaterials bom, Carport carport, SVG dimensionsSVG) {
        int x1;
        int y1;
        int x2;
        int y2;

        x1= 100;
        y1= carport.getWidth()+40;
        x2= carport.getLength();
        y2= y1;
        dimensionsSVG.addDimensionXLine(x1, y1, x2, y2);
        dimensionsSVG.addArrowDefinitions();
        dimensionsSVG.addDefinitionLineText(carport.getLength()/2,carport.getWidth()+50, 0, carport.getLength());


    }

    private static void drawStolpe(BillOfMaterials bom, Carport carport, SVG svg) {
        double width;
        double yStart;
        double y2Start;
        double stolpeWidth = 22.0;
        double indrykningXakse = 50.0;
        double stolpeAfstand;
        int stolpeAntal;

//        efter Foghs vejledning om 35 cm. til rem
        yStart = 35.0 - stolpeWidth + 4.5;
        y2Start = Double.valueOf(carport.getWidth()) - (35 + 4.5);
        width = Double.valueOf(carport.getLength());
        stolpeAntal = bom.getStolpe().getStolpeAntal();
        stolpeAfstand = (width - 2 * indrykningXakse - stolpeWidth) / (stolpeAntal / 2 - 1);
        System.out.println("afstand ml. stolper" + stolpeAfstand);

        for (int x = 0; x < ((bom.getStolpe().getStolpeAntal())/2); x++) {

            svg.addRect(indrykningXakse + x * stolpeAfstand, yStart, stolpeWidth, stolpeWidth);
            svg.addRect(indrykningXakse + x * stolpeAfstand, y2Start, stolpeWidth, stolpeWidth);

        }
    }

    private static void drawRem(BillOfMaterials bom, Carport carport, SVG svg) {
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

    public static void drawSpær(BillOfMaterials bom, Carport carport, SVG svg) {
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
