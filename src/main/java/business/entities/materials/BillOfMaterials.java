package business.entities.materials;

public class BillOfMaterials {
    private Stolpe stolpe;
    private Rem rem;
    private Spær spær;
    private OversternSider oversternSider;
    private OversternEnder oversternEnder;
    private double bomSamletPris;

    public BillOfMaterials(Stolpe stolpe, Rem rem, Spær spær, OversternSider oversternSider, OversternEnder oversternEnder, double bomSamletPris) {
        this.stolpe = stolpe;
        this.rem = rem;
        this.spær = spær;
        this.oversternSider = oversternSider;
        this.oversternEnder = oversternEnder;
        this.bomSamletPris = bomSamletPris;
    }

    public OversternSider getOversternSider() {
        return oversternSider;
    }

    public void setOversternSider(OversternSider oversternSider) {
        this.oversternSider = oversternSider;
    }

    public OversternEnder getOversternEnder() {
        return oversternEnder;
    }

    public void setOversternEnder(OversternEnder oversternEnder) {
        this.oversternEnder = oversternEnder;
    }

    public Stolpe getStolpe() {
        return stolpe;
    }

    public void setStolpe(Stolpe stolpe) {
        this.stolpe = stolpe;
    }

    public Rem getRem() {
        return rem;
    }

    public void setRem(Rem rem) {
        this.rem = rem;
    }

    public Spær getSpær() {
        return spær;
    }

    public void setSpær(Spær spær) {
        this.spær = spær;
    }

    public double getBomSamletPris() {
        return bomSamletPris;
    }

    public void setBomSamletPris(double bomSamletPris) {
        this.bomSamletPris = bomSamletPris;
    }
}
