package business.services;

import java.util.Locale;

public class SVG {
    StringBuilder svg = new StringBuilder();

    private int x;
    private int y;
    private String viewBox;
    private int width;
    private int height;

    private final String headerTemplate = "<svg version=\"1.1\"\n" +
            "         xmlns=\"http://www.w3.org/2000/svg\""+"height=\"%d%%\" " +
            "width=\"%d%%\" " +
            "viewBox=\"%s\" " +
            "x=\"%d\"   " +
            "y=\"%d\"   " +
            " preserveAspectRatio=\"xMinYMin\">";

    private final String headerInnerSVGTemplate = "<svg version=\"1.1\"\n" +
            "         xmlns=\"http://www.w3.org/2000/svg\"" +
            "width=\"%d\" " +
            "viewBox=\"%s\" " +
            "x=\"%d\"   " +
            "y=\"%d\"   " +
            " preserveAspectRatio=\"xMinYMin\">";

    private final String rectTemplate = "<rect x=\"%f\" y=\"%f\" height=\"%f\" width=\"%f\" style=\"stroke:#000000; fill: #ffffff\" />";

    private final String dimensionLineTemplate =


            "            <line x1=\"%d\" y1=\"%d\" x2=\"%d\" y2=\"%d\"\n" +
            "        style=\"stroke: #000000;\n" +
            "        marker-start: url(#beginArrow);\n" +
            "        marker-end: url(#endArrow);\"/>\n";

    private final String dimensionLineTextTemplate =
            "                <text style=\"text-anchor: middle\" transform=\"translate(%d,%d) rotate(%d)\">%d cm</text>\n";


    public SVG(int x, int y, String viewBox, int width, int height) {
        this.x = x;
        this.y = y;
        this.viewBox = viewBox;
        this.width = width;
        this.height = height;
        svg.append(String.format(headerTemplate, height, width, viewBox, x, y));
    }
    public SVG(int x, int y, String viewBox, int width) {
        this.x = x;
        this.y = y;
        this.viewBox = viewBox;
        this.width = width;
        this.height = height;
        svg.append(String.format(headerInnerSVGTemplate, width, viewBox, x, y));
    }

    public void addRect(double x, double y, double height, double width) {
        svg.append(String.format(Locale.US, rectTemplate, x, y, height, width));

    }

    public void addLine(int x1, int y1, int x2, int y2) {

    }
    public void addDimensionXLine(int x1, int y1, int x2, int y2){
        svg.append(String.format(dimensionLineTemplate, x1, y1, x2, y2));


    }

    public void addSvg(SVG innerSVG) {
        svg.append(innerSVG.toString());

    }

    public void addArrowDefinitions(){
        svg.append(
        "                  <defs>\n" +
                "                <marker\n" +
                "                id=\"beginArrow\"\n" +
                "        markerWidth=\"12\"\n" +
                "        markerHeight=\"12\"\n" +
                "        refX=\"0\"\n" +
                "        refY=\"6\"\n" +
                "        orient=\"auto\">\n" +
                "                    <path d=\"M0,6 L12,0 L12,12 L0,6\" style=\"fill: #000000;\"/>\n" +
                "                </marker>\n" +
                "                <marker\n" +
                "                id=\"endArrow\"\n" +
                "        markerWidth=\"12\"\n" +
                "        markerHeight=\"12\"\n" +
                "        refX=\"12\"\n" +
                "        refY=\"6\"\n" +
                "        orient=\"auto\">\n" +
                "                    <path d=\"M0,0 L12,6 L0,12 L0,0 \" style=\"fill: #000000;\"/>\n" +
                "                </marker>\n" +
                "            </defs>\n");

    }

    public void addDefinitionLineText(int translateX, int translateY, int rotate, int size) {
        svg.append(String.format(dimensionLineTextTemplate, translateX, translateY, rotate, size));

    }

    @Override
    public String toString() {
        return svg.toString() + "</svg>";
    }


}