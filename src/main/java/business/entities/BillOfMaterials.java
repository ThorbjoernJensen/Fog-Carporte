package business.entities;

public class BillOfMaterials {



    //    Stolpe stolper;
    private int stolpeAntal;
    private int stolpeLaengde;

    //    OverStender for og bag
    private int overstenderAntal;
    private int overstender;

    public BillOfMaterials(int stolpeAntal, int stolpeLaengde) {
        this.stolpeAntal = stolpeAntal;
        this.stolpeLaengde = stolpeLaengde;
    }

    public BillOfMaterials(int stolpeAntal, int stolpeLaengde, int overstenderAntal, int overstender) {
        this.stolpeAntal = stolpeAntal;
        this.stolpeLaengde = stolpeLaengde;
        this.overstenderAntal = overstenderAntal;
        this.overstender = overstender;
    }

    public int getOverstenderAntal() {
        return overstenderAntal;
    }

    public int getOverstender() {
        return overstender;
    }

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
}
