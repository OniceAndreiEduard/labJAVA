package ex;

import java.util.Comparator;
import java.util.Objects;
import java.util.Set;

public class Dulap extends Mobilier {
    private int nrRafturi;
    private float inaltime;

    //fiind json avem
    public Dulap() {
    }

    public Dulap(String producator, float pret, int nrRafturi, float inaltime) {
        super(producator, pret);
        this.nrRafturi = nrRafturi;
        this.inaltime = inaltime;
    }

    //equals pt set si map
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dulap dulap = (Dulap) o;                                                            //nu uita de super aici
        return nrRafturi == dulap.nrRafturi && Float.compare(inaltime, dulap.inaltime) == 0 && super.equals(o);
    }

    //hashcode pt set si map
    @Override
    public int hashCode() {//super sa nu uit aici
        return Objects.hash(super.hashCode(), nrRafturi, inaltime);
    }

    //subpunctul 5
    public static void cms_dulap(Set<Mobilier>lista)
    {
        lista.stream()
                .filter(d->d instanceof Dulap)
                .map(d->((Dulap)d))
                .min(Comparator.comparing(Dulap::getInaltime))
                .ifPresentOrElse(
                        d-> System.out.println("Cel mai scund dulap este: "+d),
                        ()-> System.out.println("Nu exista dulapuri!")
                );
    }


    public int getNrRafturi() {
        return nrRafturi;
    }

    public void setNrRafturi(int nrRafturi) {
        this.nrRafturi = nrRafturi;
    }

    public float getInaltime() {
        return inaltime;
    }

    public void setInaltime(float inaltime) {
        this.inaltime = inaltime;
    }

    @Override
    public String toString() {
        return "Dulap{" +
                "nrRafturi=" + nrRafturi +
                ", inaltime=" + inaltime +
                '}' + super.toString();
    }
}
