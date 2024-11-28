package exercitiu;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.swing.*;

public class Masina extends Autoturism {
    private int pret;
    private String model;

    public Masina() {}
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

    public void setPret(int pret) {
        this.pret = pret;
    }

    public Masina(String firma, Combustibil combustibilul, int pret, String model) {
        super(firma, combustibilul);
        this.pret = pret;
        this.model = model;
    }
}
