import org.junit.Test;
import problema_lab_6.Angajat;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class TestSalarMarit {
    @Test
    public void test1() {
        Angajat angajat1 = new Angajat("Andrei", "Director", LocalDate.of(1990, 12, 03), 250);
        assertEquals(500.0f, angajat1.salar_marit(250), 0.01f);
    }

    @Test
    public void test2() {
        Angajat angajat2 = new Angajat("Andrei", "Director", LocalDate.of(1990, 12, 03), 25);
        assertEquals(20.0f, angajat2.salar_marit(25), 0.01f);
    }
}
