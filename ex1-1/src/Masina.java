import javax.swing.*;

public class Masina extends Autoturism {
    private float pret;
    private String model;

    @Override
    public String toString() {
        return "Masina{" +
                "pret=" + pret +
                ", model='" + model + '\'' +
                '}'+super.toString();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public Masina(String firma, Combustibil combustibilul, float pret, String model) {
        super(firma, combustibilul);
        this.pret = pret;
        this.model = model;
    }
}