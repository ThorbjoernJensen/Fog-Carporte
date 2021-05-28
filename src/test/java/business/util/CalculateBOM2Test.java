package business.util;

import business.entities.Carport;
import business.entities.materials.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateBOM2Test {
    Carport carport;
    Carport carport2;
    Carport carport3;
    CalculateBOM2 calculateBOM2;


    @BeforeEach
    void setUp() {
        //public Carport(int height, int length, int width)
        carport = new Carport(250, 604, 600);
        carport2 = new Carport(250, 499, 600);
        carport3 = new Carport(250, 605, 600);
        calculateBOM2 = new CalculateBOM2(carport);
    }

    @Test
    void testCalculateStolper() {

    }

    @Test
    void calculateStolper() {
        Materiale stolpe1 = calculateBOM2.calculateStolper(carport);
        Materiale stolpe2 = calculateBOM2.calculateStolper(carport2);

        assertEquals(6, stolpe1.getAntal());
        assertEquals(4, stolpe2.getAntal());
        assertEquals(340, stolpe2.getLaengde());
        assertEquals("stolpe", stolpe2.getMaterialeType());

        double samletPris = stolpe2.getAntal() * stolpe2.getLaengde() * stolpe2.getSamletPris() / 100;
        assertEquals(136, stolpe2.getSamletPris());

    }

}