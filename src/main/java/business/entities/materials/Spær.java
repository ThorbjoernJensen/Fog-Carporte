package business.entities.materials;

public class Spær {

    private int spærAntal;
    private int spærLaengde;
    private int samletPris;
    private double centerAfstand;

    private static final int meterPris = 10;
    private static final int maxAfstand = 60;

    public Spær(int spærAntal, int spærLaengde, double centerAfstand, int samletPris) {
        this.spærAntal = spærAntal;
        this.spærLaengde = spærLaengde;
        this.centerAfstand = centerAfstand;
        this.samletPris = samletPris;
    }


    public int getSpærAntal() {
        return spærAntal;
    }

    public void setSpærAntal(int spærAntal) {
        this.spærAntal = spærAntal;
    }

    public int getSpærLaengde() {
        return spærLaengde;
    }

    public void setSpærLaengde(int spærLaengde) {
        this.spærLaengde = spærLaengde;
    }

    public double getCenterAfstand() {
        return centerAfstand;
    }

    public void setCenterAfstand(double centerAfstand) {
        this.centerAfstand = centerAfstand;
    }

    public int getSamletPris() {
        return samletPris;
    }

    public void setSamletPris(int samletPris) {
        this.samletPris = samletPris;
    }

    public static int getMeterPris() {
        return meterPris;
    }

    public static int getMaxAfstand() {
        return maxAfstand;
    }
}
