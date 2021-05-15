package business.entities.materials;

public class Stolpe {
    //    Stolpe stolper;
    private int stolpeAntal;
    private int stolpeLaengde;
    private int meterPris;
    private int samletpris;

    public Stolpe(int stolpeAntal, int stolpeLaengde, int samletpris) {
        this.stolpeAntal = stolpeAntal;
        this.stolpeLaengde = stolpeLaengde;
        this.samletpris = samletpris;
    }


    public Stolpe(int stolpeAntal, int stolpeLaengde) {
        this.stolpeAntal = stolpeAntal;
        this.stolpeLaengde = stolpeLaengde;
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
