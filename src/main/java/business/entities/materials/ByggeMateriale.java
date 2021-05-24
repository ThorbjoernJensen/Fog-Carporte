package business.entities.materials;

public class ByggeMateriale implements Materiale{
    private String materialType;
    private int antal;
    private int laengde;
    private double meterPris;
    private double samletPris;

    public ByggeMateriale(String materialType, int antal, int laengde, double meterPris, double samletPris) {
        this.materialType = materialType;
        this.antal = antal;
        this.laengde = laengde;
        this.meterPris = meterPris;
        this.samletPris = samletPris;
    }

    @Override
    public String getMaterialeType() {
        return materialType;
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

    public double getMeterPris() {
        return meterPris;
    }

    public void setMeterPris(double meterPris) {
        this.meterPris = meterPris;
    }
}
