package business.entities.materials;

public class Overstern {
    private int oversternAntal;
    private int oversternLaengde;

    public Overstern(int oversternAntal, int oversternLaengde) {
        this.oversternAntal = oversternAntal;
        this.oversternLaengde = oversternLaengde;
    }

    public int getOversternAntal() {
        return oversternAntal;
    }

    public void setOversternAntal(int oversternAntal) {
        this.oversternAntal = oversternAntal;
    }

    public int getOversternLaengde() {
        return oversternLaengde;
    }

    public void setOversternLaengde(int oversternLaengde) {
        this.oversternLaengde = oversternLaengde;
    }
}
