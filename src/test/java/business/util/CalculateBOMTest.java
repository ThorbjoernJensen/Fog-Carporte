package business.util;

import business.entities.Carport;
import business.entities.materials.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateBOMTest {
    Carport carport;
    Carport carport2;
    Carport carport3;

    @BeforeEach
    void setUp() {
    //public Carport(int height, int length, int width)
        carport = new Carport(250, 604, 600);
        carport2 = new Carport(250, 499, 600);
        carport3 = new Carport(250, 605, 600);
    }

    @Test
    void calculateStolper() {
        Stolpe stolpe1 = CalculateBOM.calculateStolper(carport);
        Stolpe stolpe2 = CalculateBOM.calculateStolper(carport2);

        assertEquals(6, stolpe1.getAntal());
        assertEquals(4, stolpe2.getAntal());
        assertEquals(340, stolpe2.getLaengde());

        double samletPris = stolpe2.getAntal() * stolpe2.getLaengde() * stolpe2.getMeterPris()/100;
        assertEquals(136, stolpe2.getSamletPris());

    }

    @Test
    void calculateRem() {
        Rem rem = CalculateBOM.calculateRem(carport);

        assertEquals(2, rem.getAntal());
        assertEquals(604, rem.getLaengde());

        double samletPris = (rem.getAntal() * rem.getLaengde() * rem.getMeterPris())/100;
        assertEquals(120.8, rem.getSamletPris());
        assertEquals(samletPris, rem.getSamletPris());

    }


    @Test
    void calculateSpær() {
        Spær spær = CalculateBOM.calculateSpær(carport);
        Spær spær3 = CalculateBOM.calculateSpær(carport3);

        assertEquals(11, spær.getAntal());
        assertEquals(12, spær3.getAntal());
        assertEquals(600, spær.getLaengde());

        double samletPris = spær.getAntal() * spær.getLaengde() * spær.getMeterPris()/100;
        assertEquals(samletPris, spær.getSamletPris());
        assertEquals(54.95, spær.getCenterAfstand());
        assertEquals(59, spær3.getCenterAfstand());

    }


    @Test
    void calcultateOversternSider() {
        OversternSider oversternSider = CalculateBOM.calcultateOversternSider(carport);

        assertEquals(604, oversternSider.getLaengde());
        assertEquals(120.8, oversternSider.getSamletPris());


    }

    @Test
    void calcultateOversternEnder() {
        OversternEnder oversternEnder = CalculateBOM.calcultateOversternEnder(carport);

        assertEquals(600, oversternEnder.getLaengde());
        assertEquals(120, oversternEnder.getSamletPris());

    }
}