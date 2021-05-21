package business.entities.materials;

public class OversternSider {
    private int antal;
    private int laengde;
    private double samletPris;

    private static final double meterPris = 10.0;

    public OversternSider(int antal, int laengde, double samletPris) {
        this.antal = antal;
        this.laengde = laengde;
        this.samletPris = samletPris;
    }

    public int getAntal() {
        return antal;
    }

    public void setAntal(int antal) {
        this.antal = antal;
    }

    public int getLaengde() {
        return laengde;
    }

    public void setLaengde(int laengde) {
        this.laengde = laengde;
    }

    public double getSamletPris() {
        return samletPris;
    }

    public void setSamletPris(double samletPris) {
        this.samletPris = samletPris;
    }

    public static double getMeterPris() {
        return meterPris;
    }
}
