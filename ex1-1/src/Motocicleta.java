import java.time.LocalDate;

public class Motocicleta extends Autoturism {
    private LocalDate dataFabricatiei;

    @Override
    public String toString() {
        return "Motocicleta{" +
                "dataFabricatiei=" + dataFabricatiei +
                '}'+super.toString();
    }

    public LocalDate getDataFabricatiei() {
        return dataFabricatiei;
    }

    public void setDataFabricatiei(LocalDate dataFabricatiei) {
        this.dataFabricatiei = dataFabricatiei;
    }
    public int vechimea()
    {
        return LocalDate.now().getYear()-dataFabricatiei.getYear();
    }

    public Motocicleta(String firma, Combustibil combustibilul, LocalDate dataFabricatiei) {
        super(firma, combustibilul);
        this.dataFabricatiei = dataFabricatiei;
    }
}