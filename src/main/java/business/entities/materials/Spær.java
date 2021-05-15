package business.entities.materials;

public class Spær {

    private int spærAntal;
    private int spærLaengde;
    private int spærMaxAfstand;
    private int meterPris;
    private int samletpris;

    public Spær(int spærAntal, int spærLaengde, int spærMaxAfstand, int samletpris) {
        this.spærAntal = spærAntal;
        this.spærLaengde = spærLaengde;
        this.spærMaxAfstand = spærMaxAfstand;
        this.samletpris = samletpris;
    }

    public Spær(int spærAntal, int spærLaengde, int spærMaxAfstand) {
        this.spærAntal = spærAntal;
        this.spærLaengde = spærLaengde;
        this.spærMaxAfstand = spærMaxAfstand;
    }

    public Spær(int spærLaengde, int spærMaxAfstand) {
        this.spærLaengde = spærLaengde;
        this.spærMaxAfstand = spærMaxAfstand;
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


    public int getSpærAntal() {
        return spærAntal;
    }

    public int getSpærMaxAfstand() {
        return spærMaxAfstand;
    }

    public void setSpærMaxAfstand(int spærMaxAfstand) {
        this.spærMaxAfstand = spærMaxAfstand;
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
}
