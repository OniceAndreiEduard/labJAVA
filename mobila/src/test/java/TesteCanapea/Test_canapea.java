package TesteCanapea;

import ex.Canapea;
import ex.TipCanapea;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Test_canapea {
    @Test
    public void test_canapea1() {
        Canapea c1 = new Canapea("Larisa",120.99f,2, TipCanapea.Clasica);
        assertEquals(80f,c1.lungime_canapea(2),0.1f);
    }

    @Test
    public void test_canapea2() {
        Canapea c2 = new Canapea("Bojan",5000.99f,6, TipCanapea.Extensibila);
        assertTrue(c2.lungime_canapea(6)==23f);
    }
}
