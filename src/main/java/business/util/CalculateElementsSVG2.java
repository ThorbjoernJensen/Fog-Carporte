package business.util;

import business.entities.Carport;
import business.entities.materials.BillOfMaterials;
import business.entities.materials.Materiale;
import business.services.SVG;

import java.util.List;

public class CalculateElementsSVG2 {
    private BillOfMaterials bom;
    private SVG svg;
    private List<Materiale> stykliste;

    public static void calculateElements(List<Materiale> stykliste, Carport carport, SVG svg) {
        SVG materialSVG;

        String viewBoxTemplate = "0 0 %s %s";
        String xCanvas = String.valueOf(carport.getLength());
        String yCanvas = String.valueOf(carport.getWidth());
        String viewBox = String.format(viewBoxTemplate, xCanvas, yCanvas);

        materialSVG = new SVG(100, 10, viewBox, carport.getLength());

        for (Materiale materiale : stykliste) {
            if (materiale.getMaterialeType().equals("rem")) {
                drawStolpe(materiale, carport, materialSVG);
            }
            if (materiale.getMaterialeType().equals("stolpe")) {
                drawRem(materiale, carport, materialSVG);
            }
            if (materiale.getMaterialeType().equals("spær")) {
                drawSpær(materiale, carport, materialSVG);
            }

            svg.addSvg(materialSVG);

        }

        String xCanvasDimensions = String.valueOf((carport.getLength()+100));
        String yCanvasSimensions = String.valueOf((carport.getWidth()+100));
        String viewBoxDimensions = String.format(viewBoxTemplate, xCanvasDimensions, yCanvasSimensions);

        SVG dimensionsSVG = new SVG(0, 0, viewBoxDimensions, carport.getLength()+100);
        drawArrawX(carport, dimensionsSVG);
        drawArrawY(carport, dimensionsSVG);
        svg.addSvg(dimensionsSVG);
    }



    private static void drawStolpe(Materiale materiale, Carport carport, SVG svg) {
        double width;
        double yStart;
        double y2Start;
        double stolpeWidth = 22.0;
        double indrykningXakse = 50.0;
        double stolpeAfstand;
        int stolpeAntal;

//        efter Foghs vejledning om 35 cm. til rem
//        stolper skal have remmen monteret på udvendig side
        yStart = 35.0;
        y2Start = Double.valueOf(carport.getWidth()) - (35 + 22.0);
        width = Double.valueOf(carport.getLength());
        stolpeAntal = materiale.getAntal();
        stolpeAfstand = (width - 2 * indrykningXakse - stolpeWidth) / (stolpeAntal / 2 - 1);

        for (int x = 0; x < ((stolpeAntal) / 2); x++) {

            svg.addRect(indrykningXakse + x * stolpeAfstand, yStart, stolpeWidth, stolpeWidth);
            svg.addRect(indrykningXakse + x * stolpeAfstand, y2Start, stolpeWidth, stolpeWidth);

        }
    }

    private static void drawRem(Materiale materiale, Carport carport, SVG svg) {
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

    public static void drawSpær(Materiale materiale, Carport carport, SVG svg) {
        double height;
        double width;
        height = Double.valueOf(carport.getWidth() - 5);
        int antalSpær = materiale.getAntal();

        double centerafstand = (carport.getLength() - 4.5) / Double.valueOf(antalSpær - 1);

        for (int x = 0; x < antalSpær; x++) {
            svg.addRect(centerafstand * x, 0, height, 4.5);
        }
    }

    private static void drawArrawX(Carport carport, SVG dimensionsSVG) {
        int x1;
        int y1;
        int x2;
        int y2;

        x1 = 50;
        y1 = 10;
        x2 = x1;
        y2 = carport.getWidth() + y1;
        dimensionsSVG.addDimensionXLine(x1, y1, x2, y2);
        dimensionsSVG.addArrowDefinitions();
        dimensionsSVG.addDefinitionLineText(40, carport.getWidth() / 2, -90, carport.getWidth());


    }

    private static void drawArrawY(Carport carport, SVG dimensionsSVG) {
        int x1;
        int y1;
        int x2;
        int y2;

        x1 = 100;
        y1 = carport.getWidth() + 40;
        x2 = carport.getLength() + x1;
        y2 = y1;
        dimensionsSVG.addDimensionXLine(x1, y1, x2, y2);
        dimensionsSVG.addArrowDefinitions();
        dimensionsSVG.addDefinitionLineText((carport.getLength() / 2 + 100), carport.getWidth() + 60, 0, carport.getLength());


    }


}
