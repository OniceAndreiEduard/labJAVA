import java.time.LocalDate;

public class Pisica extends Animal {
    String greutate;
    String rasa;

    @Override
    public String toString() {
        return "Pisica{" +
                "greutate='" + greutate + '\'' +
                ", rasa='" + rasa + '\'' +
                '}'+super.toString();
    }

    public String getGreutate() {
        return greutate;
    }

    public void setGreutate(String greutate) {
        this.greutate = greutate;
    }

    public String getRasa() {
        return rasa;
    }

    public void setRasa(String rasa) {
        this.rasa = rasa;
    }

    public Pisica(String nume, double inaltime, LocalDate data_nasterii, Talie talia, String greutate, String rasa) {
        super(nume, inaltime, data_nasterii, talia);
        this.greutate = greutate;
        this.rasa = rasa;
    }

    public Pisica(String greutate, String rasa) {
        this.greutate = greutate;
        this.rasa = rasa;
    }
}
