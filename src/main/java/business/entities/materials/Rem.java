package business.entities.materials;

public class Rem {

    private int remAntal;
    private int remLaengde;
    private int meterPris;
    private int samletpris;



    public Rem(int remAntal, int remLaengde, int meterPris, int samletpris) {
        this.remAntal = remAntal;
        this.remLaengde = remLaengde;
        this.meterPris=meterPris;
        this.samletpris=samletpris;

    }
    public int getMeterPris() {
        return meterPris;
    }

    public int getSamletpris() {
        return samletpris;
    }

    public void setSamletpris(int samletpris) {
        this.samletpris = samletpris;
    }

    public void setMeterPris(int meterPris) {
        this.meterPris = meterPris;
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
