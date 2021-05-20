package business.services;

import java.util.Locale;

public class SVG {
    StringBuilder svg = new StringBuilder();

    private int x;
    private int y;
    private String viewBox;
    private int width;
    private int height;

    private final String headerTemplate = "<svg height=\"%d%%\" " +
            "width=\"%d%%\" " +
            "viewBox=\"%s\" " +
            "x=\"%d\"   " +
            "y=\"%d\"   " +
            " preserveAspectRatio=\"xMinYMin\">";

    private final String rectTemplate = "<rect x=\"%f\" y=\"%f\" height=\"%f\" width=\"%f\" style=\"stroke:#000000; fill: #ffffff\" />";

    private final String dimensionsTemplate = "<defs>\n" +
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
            "            </defs>\n" +
            "            <line x1=\"50\" y1=\"610\" x2=\"50\" y2=\"10\"\n" +
            "        style=\"stroke: #000000;\n" +
            "        marker-start: url(#beginArrow);\n" +
            "        marker-end: url(#endArrow);\"/>\n" +
            "                <text style=\"text-anchor: middle\" transform=\"translate(40,300) rotate(-90)\">600 cm</text>\n" +
            "\n" +
            "            <defs>\n" +
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
            "            </defs>\n" +
            "            <line x1=\"100\" y1=\"650\" x2=\"880\" y2=\"650\"\n" +
            "        style=\"stroke: #000000;\n" +
            "        marker-start: url(#beginArrow);\n" +
            "        marker-end: url(#endArrow);\"/>\n" +
            "                <text style=\"text-anchor: middle\" transform=\"translate(500,680) rotate(0)\">780 cm</text>";

    public SVG(int x, int y, String viewBox, int width, int height) {
        this.x = x;
        this.y = y;
        this.viewBox = viewBox;
        this.width = width;
        this.height = height;
        svg.append(String.format(headerTemplate, height, width, viewBox, x, y));
    }

    public void addRect(double x, double y, double height, double width) {
        svg.append(String.format(Locale.US, rectTemplate, x, y, height, width));

    }

    public void addLine(int x1, int y1, int x2, int y2) {

    }
    public void addDimensions(){
        svg.append(String.format(Locale.US, dimensionsTemplate));


    }

    public void addSvg(SVG innerSVG) {
        svg.append(innerSVG.toString());

    }
    public void closeSvg() {
        svg.append("</svg>");

    }

    @Override
    public String toString() {
        return svg.toString() + "</svg>";
    }
}