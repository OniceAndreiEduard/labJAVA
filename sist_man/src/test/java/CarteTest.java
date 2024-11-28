import org.junit.Test;
import rezolvare.Carte;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CarteTest {
    @Test
    public void test_numar_cuv() {
        Carte carte = new Carte("Test Book", "Author", 2024, 100);
        assertEquals(4000, carte.numar_cuvinte(100));
    }
    @Test
    public void testNumarCuvinteEmpty() {
        Carte carte = new Carte("Empty Book", "No Author", 2024, 2);
        assertEquals(10, carte.numar_cuvinte(500));
    }

}
