package business.entities.materials;

public class Rem {

    private int remAntal;
    private int remLaengde;

    public Rem(int remAntal, int remLaengde) {
        this.remAntal = remAntal;
        this.remLaengde = remLaengde;
    }

    public int getRemAntal() {
        return remAntal;
    }

    public void setRemAntal(int remAntal) {
        this.remAntal = remAntal;
    }

    public int getRemLaengde() {
        return remLaengde;
    }

    public void setRemLaengde(int remLaengde) {
        this.remLaengde = remLaengde;
    }
}
