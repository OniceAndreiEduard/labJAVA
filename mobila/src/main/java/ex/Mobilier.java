package ex;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.util.Comparator;
import java.util.Objects;
import java.util.Set;

//tot timpul se baga asta deasupra clasei abstracte
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public abstract class Mobilier {
    private String producator;
    private float pret;

    //fiind json avem
    public Mobilier() {
    }

    public Mobilier(String producator, float pret) {
        this.producator = producator;
        this.pret = pret;
    }

    //equals pentru problemele set si map
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mobilier mobilier = (Mobilier) o;
        return Float.compare(pret, mobilier.pret) == 0 && Objects.equals(producator, mobilier.producator);
    }
    //hashcode pentru set si map tot timpul
    @Override
    public int hashCode() {
        return Objects.hash(producator, pret);
    }

    public String getProducator() {
        return producator;
    }

    public void setProducator(String producator) {
        this.producator = producator;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "Mobilier{" +
                "producator='" + producator + '\'' +
                ", pret=" + pret +
                '}';
    }
}
