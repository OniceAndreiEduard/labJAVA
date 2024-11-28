package rezolvare;

public class Publicatie {
    private String titlu;
    private String autor;
    private int an_publicare;

    @Override
    public String toString() {
        return "Publicatie{" +
                "titlu='" + titlu + '\'' +
                ", autor='" + autor + '\'' +
                ", an_publicare=" + an_publicare +
                '}';
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAn_publicare() {
        return an_publicare;
    }

    public void setAn_publicare(int an_publicare) {
        this.an_publicare = an_publicare;
    }

    public Publicatie(String titlu, String autor, int an_publicare) {
        this.titlu = titlu;
        this.autor = autor;
        this.an_publicare = an_publicare;
    }
}
