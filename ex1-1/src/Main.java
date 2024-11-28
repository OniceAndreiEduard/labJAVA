import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

//problema rezolvata de nota 8,5

public class Main {
    public static void citire(List<Autoturism> lista) throws FileNotFoundException {
        Scanner scfisier=new Scanner(new File("ex1-1/src/autoturisme.csv"));
        String linie;

        while(scfisier.hasNext())
        {
            linie= scfisier.nextLine();
            String [] valori=linie.split(",");

            String tip=valori[0];
            String firma=valori[1];
            Combustibil combustibil= Combustibil.valueOf(valori[2]);

            if(tip.equalsIgnoreCase("Masina"))
            {
                Float pret=Float.parseFloat(valori[3]);
                String model=valori[4];
                Masina mas=new Masina(firma,combustibil,pret,model);
                lista.add(mas);
            } else if (tip.equalsIgnoreCase("Motocicleta")) {
                LocalDate data_fabricare= LocalDate.parse(valori[3]);
                Motocicleta moto=new Motocicleta(firma,combustibil,data_fabricare);
                lista.add(moto);
            }
        }
        scfisier.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        List<Autoturism>lista=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        citire(lista);

        System.out.println("\nAfisarea colectiei de autoturisme: \n");
        lista.forEach(System.out::println);

        boolean valid=false;
        String firma="";
        do{
            System.out.println("Introduceti firma de autoturisme: ");
            firma=sc.nextLine();

            if(firma.matches("[a-zA-Z]+"))
            {
                valid=true;
            }
            else {
                System.out.println("Firma trebuie sa contina doar litere!");
            }
        }while(!valid);
        Autoturism aut=lista.get(0);
        if(aut.getFirma().equals(firma))
        {
            System.out.println("Primul autoturism din lista are aceasta firma");
        }
        else{
            System.out.println("Primul autoturism din lista nu are aceasta firma");
        }

        System.out.println("\nDati tipul de combustibil: ");
        Combustibil tipul= Combustibil.valueOf(sc.next());
        System.out.println("\nDatele autoturismelor care au "+tipul+": \n");
        lista.stream()
                .filter(a->a.getCombustibilul().equals(tipul))
                .forEach(System.out::println);

        System.out.println("\nMotocicleta cea mai veche este: \n");
        lista.stream()
                .filter(m->m instanceof Motocicleta)
                .map(m->(Motocicleta)m)
                .min((m1,m2)->m1.getDataFabricatiei().compareTo(m2.getDataFabricatiei()))
                .ifPresentOrElse(System.out::println,
                        ()-> System.out.println("Nu exista motociclete in lista")
                );

    }
}