package rezolvare;

public class Revista extends Publicatie{
    private int numarExemplare;

    @Override
    public String toString() {
        return "Revista{" +
                "numarExemplare=" + numarExemplare +
                '}'+super.toString();
    }

    public int getNumarExemplare() {
        return numarExemplare;
    }

    public void setNumarExemplare(int numarExemplare) {
        this.numarExemplare = numarExemplare;
    }

    public Revista(String titlu, String autor, int an_publicare, int numarExemplare) {
        super(titlu, autor, an_publicare);
        this.numarExemplare = numarExemplare;
    }
}
