package business.entities.materials;

public class Spær {

    private int spærAntal;
    private int spærLaengde;
    private int spærMaxAfstand=55;

    public Spær(int spærAntal, int spærLaengde) {
        this.spærAntal = spærAntal;
        this.spærLaengde = spærLaengde;
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
