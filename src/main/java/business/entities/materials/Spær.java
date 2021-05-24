package business.entities.materials;

public class Spær implements Materiale{
    private static final String materialType= "spær";
    private int antal;
    private int laengde;
    private double samletPris;
    private double centerAfstand;

    private static final double meterPris = 10.0;
    private static final int maxAfstand = 60;

    public Spær(int antal, int laengde, double centerAfstand, double samletPris) {
        this.antal = antal;
        this.laengde = laengde;
        this.centerAfstand = centerAfstand;
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

    public double getCenterAfstand() {
        return centerAfstand;
    }

    public static double getMeterPris() {
        return meterPris;
    }

    public static int getMaxAfstand() {
        return maxAfstand;
    }
}
