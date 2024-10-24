package problema_lab4;

public class Copiatoare extends Echipamente {
    private float p_ton;
    private FormatDECopiere format;

    public Copiatoare(String denumire, int nr_inv, float pret, String zona_mag, StareEchipamente stare, float p_ton, FormatDECopiere format) {
        super(denumire, nr_inv, pret, zona_mag, stare);
        this.p_ton = p_ton;
        this.format = format;
    }

    public float getP_ton() {
        return p_ton;
    }

    public void setP_ton(float p_ton) {
        this.p_ton = p_ton;
    }

    public FormatDECopiere getFormat() {
        return format;
    }

    public void setFormat(FormatDECopiere format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "Copiatoare{" +
                "p_ton=" + p_ton +
                ", format=" + format +
                '}';
    }
}
