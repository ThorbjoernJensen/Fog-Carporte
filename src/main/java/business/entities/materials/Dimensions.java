package business.entities.materials;

public class Dimensions {

    private int id;
    private int height;
    private int width;
    private int length;


    public Dimensions(int id, int height, int length, int width) {
        this.id = id;
        this.height = height;
        this.length = length;
        this.width = width;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }


}
