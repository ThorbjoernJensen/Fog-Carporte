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

    public Stolpe getStolpe() {
        return stolpe;
    }

    public Rem getRem() {
        return rem;
    }

    public Spær getSpær() {
        return spær;
    }

    public double getBomSamletPris() {
        return bomSamletPris;
    }

}
