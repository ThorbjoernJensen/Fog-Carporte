package business.entities.materials;

public class BillOfMaterials {
    Stolpe stolpe;
    Overstern overstern;
    Rem rem;

    public BillOfMaterials(Stolpe stolpe, Overstern overstern, Rem rem) {
        this.stolpe = stolpe;
        this.overstern = overstern;
        this.rem = rem;
    }

    public Rem getRem() {
        return rem;
    }

    public void setRem(Rem rem) {
        this.rem = rem;
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
