package ex;

import java.util.Objects;

public class Canapea extends Mobilier {
    private int nrLocuri;
    private TipCanapea tipCanapea;

    //fiind json avem
    public Canapea() {
    }

    //subpunctul 6
    public int lungime_canapea(int nrLocuri)
    {
        return nrLocuri*40;
    }

    //equals pentru set si map
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Canapea canapea = (Canapea) o;
        return nrLocuri == canapea.nrLocuri && tipCanapea == canapea.tipCanapea /*adaugam asta in clasele derivate*/ && super.equals(o);
    }

    @Override
    public int hashCode() {//si aici avem super
        return Objects.hash(super.hashCode(), nrLocuri, tipCanapea);
    }

    public Canapea(String producator, float pret, int nrLocuri, TipCanapea tipCanapea) {
        super(producator, pret);
        this.nrLocuri = nrLocuri;
        this.tipCanapea = tipCanapea;
    }

    public int getNrLocuri() {
        return nrLocuri;
    }

    public void setNrLocuri(int nrLocuri) {
        this.nrLocuri = nrLocuri;
    }

    public TipCanapea getTipCanapea() {
        return tipCanapea;
    }

    public void setTipCanapea(TipCanapea tipCanapea) {
        this.tipCanapea = tipCanapea;
    }

    @Override
    public String toString() {
        return "Canapea{" +
                "nrLocuri=" + nrLocuri +
                ", tipCanapea=" + tipCanapea +
                '}' + super.toString();
    }
}
