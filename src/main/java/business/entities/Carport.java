package business.entities;

public class Carport {
    private int carportId;
    private int userId;
    private int roofId;
    private int height;
    private int length;
    private int width;
    private int shedId;
    private int carportStatusId;

    public Carport(int height, int length, int width) {
        this.height = height;
        this.length = length;
        this.width = width;
    }

    public Carport(int carportId, int roofId, int height, int length, int width, int shedId) {
        this.carportId = carportId;
        this.roofId = roofId;
        this.height = height;
        this.length = length;
        this.width = width;
        this.shedId = shedId;
    }
    public Carport(int carportId, int roofId, int height, int length, int width, int shedId, int userId, int carportStatusId) {
        this.carportId = carportId;
        this.roofId = roofId;
        this.height = height;
        this.length = length;
        this.width = width;
        this.shedId = shedId;
        this.userId = userId;
        this.carportStatusId=carportStatusId;
    }

    public Carport(int carportId, int roofId, int height, int length, int width, int shedId, int userId) {
        this.carportId = carportId;
        this.roofId = roofId;
        this.height = height;
        this.length = length;
        this.width = width;
        this.shedId = shedId;
        this.userId = userId;
    }

    public int getCarportStatusId() {
        return carportStatusId;
    }

    public void setCarportStatusId(int carportStatusId) {
        this.carportStatusId = carportStatusId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public int getCarportId() {
        return carportId;
    }

    public void setCarportId(int carportId) {
        this.carportId = carportId;
    }

    public int getRoofId() {
        return roofId;
    }

    public void setRoofId(int roofId) {
        this.roofId = roofId;
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

    public int getShedId() {
        return shedId;
    }

    public void setShedId(int shedId) {
        this.shedId = shedId;
    }
}
