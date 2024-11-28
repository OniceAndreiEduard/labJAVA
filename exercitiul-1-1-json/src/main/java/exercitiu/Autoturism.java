package exercitiu;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Autoturism {
    private String firma;
    private Combustibil combustibilul;

    public Autoturism() {}
    @Override
    public String toString() {
        return "Autoturism{" +
                "firma='" + firma + '\'' +
                ", combustibilul=" + combustibilul +
                '}';
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public Combustibil getCombustibilul() {
        return combustibilul;
    }

    public void setCombustibilul(Combustibil combustibilul) {
        this.combustibilul = combustibilul;
    }

    public Autoturism(String firma, Combustibil combustibilul) {
        this.firma = firma;
        this.combustibilul = combustibilul;
    }
}
