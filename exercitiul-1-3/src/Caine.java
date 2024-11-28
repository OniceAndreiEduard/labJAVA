import java.time.LocalDate;

public class Caine extends Animal {
    boolean esteAdoptat;


    public Caine(String nume, double inaltime, LocalDate data_nasterii, Talie talia, boolean esteAdoptat) {
        super(nume, inaltime, data_nasterii, talia);
        this.esteAdoptat = esteAdoptat;
    }


    @Override
    public String toString() {
        return "Caine{" +
                "esteAdoptat=" + esteAdoptat +
                '}'+super.toString();
    }

    public boolean isEsteAdoptat() {
        return esteAdoptat;
    }

    public void setEsteAdoptat(boolean esteAdoptat) {
        this.esteAdoptat = esteAdoptat;
    }
}
