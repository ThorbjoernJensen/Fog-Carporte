package business.entities;

public class Stolpe {
    //    Stolpe stolper;
    private int stolpeAntal;
    private int stolpeLaengde;

    public Stolpe(int stolpeAntal, int stolpeLaengde) {
        this.stolpeAntal = stolpeAntal;
        this.stolpeLaengde = stolpeLaengde;
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
