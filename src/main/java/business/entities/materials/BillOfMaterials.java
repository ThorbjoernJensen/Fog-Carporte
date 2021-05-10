package business.entities.materials;

public class BillOfMaterials {
    Stolpe stolpe;
    Overstern overstern;

    public BillOfMaterials(Stolpe stolpe, Overstern overstern) {
        this.stolpe = stolpe;
        this.overstern = overstern;
    }

    public Stolpe getStolpe() {
        return stolpe;
    }

    public void setStolpe(Stolpe stolpe) {
        this.stolpe = stolpe;
    }

    public Overstern getOverstern() {
        return overstern;
    }

    public void setOverstern(Overstern overstern) {
        this.overstern = overstern;
    }
}
