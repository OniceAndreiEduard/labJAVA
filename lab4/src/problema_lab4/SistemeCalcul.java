package problema_lab4;

public class SistemeCalcul extends Echipamente{
    private String tip_mon;
    private float vit_proc;
    private int c_hdd;
    private SistemeDEOperare sisteme;

    public SistemeCalcul(String denumire, int nr_inv, double pret, String zona_mag, StareEchipamente stare, String tip_mon, double vit_proc, int c_hdd, SistemeDEOperare sisteme) {
        super(denumire, nr_inv, (float) pret, zona_mag, stare);
        this.tip_mon = tip_mon;
        this.vit_proc = (float) vit_proc;
        this.c_hdd = c_hdd;
        this.sisteme = sisteme;
    }

    public String getTip_mon() {
        return tip_mon;
    }

    public void setTip_mon(String tip_mon) {
        this.tip_mon = tip_mon;
    }

    public float getVit_proc() {
        return vit_proc;
    }

    public void setVit_proc(float vit_proc) {
        this.vit_proc = vit_proc;
    }

    public int getC_hdd() {
        return c_hdd;
    }

    public void setC_hdd(int c_hdd) {
        this.c_hdd = c_hdd;
    }

    public SistemeDEOperare getSisteme() {
        return sisteme;
    }

    public void setSisteme(SistemeDEOperare sisteme) {
        this.sisteme = sisteme;
    }

    @Override
    public String toString() {
        return super.toString()+
                "SistemeCalcul{" +
                "tip_mon='" + tip_mon + '\'' +
                ", vit_proc=" + vit_proc +
                ", c_hdd=" + c_hdd +
                ", sisteme=" + sisteme +
                '}';
    }
}
