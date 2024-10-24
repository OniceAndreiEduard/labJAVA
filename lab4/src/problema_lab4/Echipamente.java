package problema_lab4;

public class Echipamente {
    private String denumire;
    private int nr_inv;
    private float pret;
    private String zona_mag;
    private StareEchipamente stare;

    public Echipamente(String denumire, int nr_inv, float pret, String zona_mag, StareEchipamente stare) {
        this.denumire = denumire;
        this.nr_inv = nr_inv;
        this.pret = pret;
        this.zona_mag = zona_mag;
        this.stare = stare;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getNr_inv() {
        return nr_inv;
    }

    public void setNr_inv(int nr_inv) {
        this.nr_inv = nr_inv;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public String getZona_mag() {
        return zona_mag;
    }

    public void setZona_mag(String zona_mag) {
        this.zona_mag = zona_mag;
    }

    public StareEchipamente getStare() {
        return stare;
    }

    public void setStare(StareEchipamente stare) {
        this.stare = stare;
    }

    @Override
    public String toString() {
        return super.toString()+
                "Echipamente{" +
                "denumire='" + denumire + '\'' +
                ", nr_inv=" + nr_inv +
                ", pret=" + pret +
                ", zona_mag='" + zona_mag + '\'' +
                '}';
    }
}
