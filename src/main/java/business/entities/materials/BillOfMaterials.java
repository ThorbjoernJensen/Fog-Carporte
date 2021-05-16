package business.entities.materials;

public class BillOfMaterials {
    Stolpe stolpe;
    Overstern overstern;
    Rem rem;
    Spær spær;
    private double pris;

    public BillOfMaterials(Stolpe stolpe, Overstern overstern, Rem rem, Spær spær, double pris) {
        this.stolpe = stolpe;
        this.overstern = overstern;
        this.rem = rem;
        this.spær = spær;
        this.pris = pris;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
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

    public Spær getSpær() {
        return spær;
    }

    public void setSpær(Spær spær) {
        this.spær = spær;
    }
}
