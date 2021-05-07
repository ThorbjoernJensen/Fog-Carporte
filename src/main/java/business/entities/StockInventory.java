package business.entities;

public class StockInventory {

    private int materialId;
    private String materialDescription;
    private String materialByLenght;
    private int quantity;
    private int unitId;
    private Double pricePrMtr;
    private String placementDescription;

    public StockInventory(int materialId, String materialDescription, String materialByLenght, int quantity, int unitId, Double pricePrMtr, String placementDescription) {
        this.materialId = materialId;
        this.materialDescription = materialDescription;
        this.materialByLenght = materialByLenght;
        this.quantity = quantity;
        this.unitId = unitId;
        this.pricePrMtr = pricePrMtr;
        this.placementDescription = placementDescription;
    }

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    public String getMaterialDescription() {
        return materialDescription;
    }

    public void setMaterialDescription(String materialDescription) {
        this.materialDescription = materialDescription;
    }

    public String getMaterialByLenght() {
        return materialByLenght;
    }

    public void setMaterialByLenght(String materialByLenght) {
        this.materialByLenght = materialByLenght;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public Double getPricePrMtr() {
        return pricePrMtr;
    }

    public void setPricePrMtr(Double pricePrMtr) {
        this.pricePrMtr = pricePrMtr;
    }

    public String getPlacementDescription() {
        return placementDescription;
    }

    public void setPlacementDescription(String placementDescription) {
        this.placementDescription = placementDescription;
    }
}
