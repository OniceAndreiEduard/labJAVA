import java.time.LocalDate;

public class Animal {
    private  String nume;
    private  double inaltime;
    private   LocalDate data_nasterii;
    private  Talie talia;

    public Animal(String nume, double inaltime, LocalDate data_nasterii, Talie talia) {
        this.nume = nume;
        this.inaltime = inaltime;
        this.data_nasterii = data_nasterii;
        this.talia = talia;
    }
    public Animal(){}

    @Override
    public String toString() {
        return "Animal{" +
                "nume='" + nume + '\'' +
                ", inaltime='" + inaltime + '\'' +
                ", data_nasterii=" + data_nasterii +
                ", talia=" + talia +
                '}';
    }
    public int get_varsta(){
        return LocalDate.now().getYear()-data_nasterii.getYear();
    }


    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public double getInaltime() {
        return inaltime;
    }

    public void setInaltime(double inaltime) {
        this.inaltime = inaltime;
    }

    public LocalDate getData_nasterii() {
        return data_nasterii;
    }

    public void setData_nasterii(LocalDate data_nasterii) {
        this.data_nasterii = data_nasterii;
    }

    public Talie getTalia() {
        return talia;
    }

    public void setTalia(Talie talia) {
        this.talia = talia;
    }
}
