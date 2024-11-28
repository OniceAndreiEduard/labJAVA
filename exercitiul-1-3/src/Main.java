import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//problema rezolvata de nota 8,5

public class Main {
    public static void citire(List<Animal>lista) throws FileNotFoundException {

        Scanner scfisier=new Scanner(new File("exercitiul-1-3/src/animale.csv"));
        String linie;

        while(scfisier.hasNextLine()) {
            linie= scfisier.nextLine();
            String [] valori=linie.split(",");

            String tip=valori[0];
            String nume=valori[1];
            double inaltime= Double.parseDouble(valori[2]);
            LocalDate data_nasterii=LocalDate.parse(valori[3]);
            Talie talia= Talie.valueOf(valori[4].toUpperCase());

            if(tip.equalsIgnoreCase("Pisica"))
            {
                String greutate=valori[5];
                String rasa=valori[6];
                Pisica pisica=new Pisica(nume,inaltime,data_nasterii,talia,greutate,rasa);
                lista.add(pisica);
            }
            else if (tip.equalsIgnoreCase("Caine"))
            {
                boolean este_adoptat= valori[5].equalsIgnoreCase("da");
                Caine caine=new Caine(nume,inaltime,data_nasterii,talia,este_adoptat);
                lista.add(caine);
            }
        }
        scfisier.close();

    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc=new Scanner(System.in);
        List<Animal>lista=new ArrayList<>();
        citire(lista);

        //subpunctul 3
        System.out.println("\nAfisare animale: \n");
        lista.forEach(System.out::println);

        //subpunctul 4
        double inaltimea = 0.0;
        boolean valid = false;

        do {
            System.out.println("Introduceți înălțimea: ");
            if (sc.hasNextDouble()) {
                inaltimea = sc.nextDouble();
                valid = true;
            }
            else
            {
                System.out.println("Valoare invalidă. Încercați din nou!");
                sc.next();
            }
        } while (!valid);

        Animal primulAnimal = lista.get(0);
        if (primulAnimal.getInaltime() == inaltimea) {
            System.out.println("Primul animal are aceeași înălțime ");
        } else {
            System.out.println("Primul animal NU are aceeași înălțime ");
        }

        //subpnctul 6
        System.out.println("\nDati rasa pisicilor: ");
        String ras=sc.next();
        System.out.println("\nPisicile care sunt rasa "+ras+" ordonate dupa greutate: \n");
        lista.stream()
                .filter(p->p instanceof Pisica)
                .map(p->(Pisica)p)
                .filter(p->p.getRasa().equals(ras))
                .sorted((p1,p2)->p1.getGreutate().compareTo(p2.getGreutate()))
                .forEach(System.out::println);

        //subpunctul 7
        System.out.println("\nDati numarul de luni: ");
        int luni= Integer.parseInt(sc.next());
        System.out.println("\nCainii de talie mare care au fost adoptati si s au nascut in ultimele "+luni+" luni sunt: \n");
        lista.stream()
                .filter(c->c instanceof Caine)
                .map(c->(Caine)c)
                .filter(c->c.getTalia() == Talie.MARE && c.isEsteAdoptat() && c.getData_nasterii().isAfter(LocalDate.now().minusMonths(luni)))
                .forEach(System.out::println);


    }

}
