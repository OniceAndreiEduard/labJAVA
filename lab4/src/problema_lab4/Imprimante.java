package problema_lab4;

public class Imprimante extends Echipamente {
    private float ppm;
    private String dpi;
    private int p_car;
    private ModTiparire mod_tiparire;

    public Imprimante(String denumire, int nr_inv, double pret, String zona_mag, StareEchipamente stare, float ppm, String dpi, int p_car, ModTiparire mod_tiparire) {
        super(denumire, nr_inv, (float) pret, zona_mag, stare);
        this.ppm = ppm;
        this.dpi = String.valueOf(dpi);
        this.p_car = p_car;
        this.mod_tiparire = mod_tiparire;
    }

    public float getPpm() {
        return ppm;
    }

    public void setPpm(float ppm) {
        this.ppm = ppm;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(int dpi) {
        this.dpi = String.valueOf(dpi);
    }

    public int getP_car() {
        return p_car;
    }

    public void setP_car(int p_car) {
        this.p_car = p_car;
    }

    public ModTiparire getMod_tiparire() {
        return mod_tiparire;
    }

    public void setMod_tiparire(ModTiparire mod_tiparire) {
        this.mod_tiparire = mod_tiparire;
    }

    @Override
    public String toString() {
        return super.toString()+
                "Imprimante{" +
                "ppm=" + ppm +
                ", dpi=" + dpi +
                ", p_car=" + p_car +
                ", mod_tiparire=" + mod_tiparire +
                '}';
    }
}
