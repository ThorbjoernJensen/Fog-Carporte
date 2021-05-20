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
        String xCanvas = String.valueOf(carport.getLength() + 100);
        String yCanvas = String.valueOf(carport.getWidth() + 100);
        String viewBox = String.format(viewBoxTemplate, xCanvas, yCanvas);

        materialSVG = new SVG(100, 100, viewBox, 100, 50);

        drawStolpe(bom, carport, materialSVG);
        drawRem(bom, carport, materialSVG);
        drawSpær(bom, carport, materialSVG);
        svg.addSvg(materialSVG);
//        svg.closeSvg();

        SVG dimensionsSVG = new SVG(0, 0, "0 0 800 600", 80, 80);
        drawDimensions(bom, carport, dimensionsSVG);
        svg.addSvg(dimensionsSVG);


    }

    private static void drawDimensions(BillOfMaterials bom, Carport carport, SVG dimensionsSVG) {
        dimensionsSVG.addDimensions();


    }

//           <defs>
//                <marker
//                id="beginArrow"
//        markerWidth="12"
//        markerHeight="12"
//        refX="0"
//        refY="6"
//        orient="auto">
//                    <path d="M0,6 L12,0 L12,12 L0,6" style="fill: #000000;"/>
//                </marker>
//                <marker
//                id="endArrow"
//        markerWidth="12"
//        markerHeight="12"
//        refX="12"
//        refY="6"
//        orient="auto">
//                    <path d="M0,0 L12,6 L0,12 L0,0 " style="fill: #000000;"/>
//                </marker>
//            </defs>
//            <line x1="50" y1="610" x2="50" y2="10"
//        style="stroke: #000000;
//        marker-start: url(#beginArrow);
//        marker-end: url(#endArrow);"/>
//                <text style="text-anchor: middle" transform="translate(40,300) rotate(-90)">600 cm</text>
//
//            <defs>
//                <marker
//                id="beginArrow"
//        markerWidth="12"
//        markerHeight="12"
//        refX="0"
//        refY="6"
//        orient="auto">
//                    <path d="M0,6 L12,0 L12,12 L0,6" style="fill: #000000;"/>
//                </marker>
//                <marker
//                id="endArrow"
//        markerWidth="12"
//        markerHeight="12"
//        refX="12"
//        refY="6"
//        orient="auto">
//                    <path d="M0,0 L12,6 L0,12 L0,0 " style="fill: #000000;"/>
//                </marker>
//            </defs>
//            <line x1="100" y1="650" x2="880" y2="650"
//        style="stroke: #000000;
//        marker-start: url(#beginArrow);
//        marker-end: url(#endArrow);"/>
//                <text style="text-anchor: middle" transform="translate(500,680) rotate(0)">780 cm</text>
//        </svg>


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

        for (int x = 0; x < (bom.getStolpe().getStolpeAntal()); x++) {

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
