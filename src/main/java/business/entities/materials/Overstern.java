package business.entities.materials;

public class Overstern {
    private int oversternAntal;
    private int oversternLaengde;
    private int meterPris;
    private int samletpris;

    public Overstern(int oversternAntal, int oversternLaengde, int meterPris, int samletpris) {
        this.oversternAntal = oversternAntal;
        this.oversternLaengde = oversternLaengde;
        this.meterPris = meterPris;
        this.samletpris = samletpris;
    }

    public Overstern(int oversternAntal, int oversternLaengde) {
        this.oversternAntal = oversternAntal;
        this.oversternLaengde = oversternLaengde;
    }

    public int getMeterPris() {
        return meterPris;
    }

    public void setMeterPris(int meterPris) {
        this.meterPris = meterPris;
    }

    public int getSamletpris() {
        return samletpris;
    }

    public void setSamletpris(int samletpris) {
        this.samletpris = samletpris;
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
