package business.entities;

public class BillOfMaterials {

    public int getStolpeAntal() {
        return stolpeAntal;
    }

    public void setStolpeAntal(int stolpeAntal) {
        this.stolpeAntal = stolpeAntal;
    }

    public int getStolpeLaengde() {
        return stolpeLaengde;
    }

    public void setStolpeLaengde(int stolpeLaengde) {
        this.stolpeLaengde = stolpeLaengde;
    }

    //    Stolpe stolper;
    private int stolpeAntal;
    private int stolpeLaengde;

    public BillOfMaterials(int stolpeAntal, int stolpeLaengde) {
        this.stolpeAntal = stolpeAntal;
        this.stolpeLaengde = stolpeLaengde;
    }
}
