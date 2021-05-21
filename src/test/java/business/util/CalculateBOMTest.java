package business.util;

import business.entities.Carport;
import business.entities.materials.Spær;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateBOMTest {
    Carport carport;

    @BeforeEach
    void setUp() {
    //public Carport(int height, int length, int width)
        carport = new Carport(250, 604, 600);
    }

    @Test
    void calculateSpær() {
        Spær spær = CalculateBOM.calculateSpær(carport);

        assertEquals(11, spær.getSpærAntal());
        assertEquals(600, spær.getSpærLaengde());

        int samletPris = spær.getSpærAntal() * spær.getSpærLaengde() * spær.getMeterPris()/100;
        assertEquals(samletPris, spær.getSamletPris());
        assertEquals(59, spær.getCenterAfstand());

    }

    @Test
    void calculateRem() {
    }

    @Test
    void calculateStolper() {

    }

    @Test
    void calcultateOverstern() {
    }
}