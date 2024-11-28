package rezolvare;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class main {

    public static void citire(List<Publicatie> lista) throws FileNotFoundException {
        Scanner scfisier = new Scanner(new File("sist_man/src/main/java/rezolvare/biblioteca.csv"));
        String linie;

        while (scfisier.hasNext()) {
            linie = scfisier.nextLine();
            String[] valori = linie.split(",");

            String tip = valori[0];
            String titlu = valori[1];
            String autor = valori[2];
            int an_publicares = Integer.parseInt(valori[3]);

            if (tip.equalsIgnoreCase("Carte")) {
                int numar_pag = Integer.parseInt(valori[4]);
                Carte c = new Carte(titlu, autor, an_publicares, numar_pag);
                lista.add(c);
            } else if (tip.equalsIgnoreCase("Revista")) {
                int numar_exemplare = Integer.parseInt(valori[4]);
                Revista r = new Revista(titlu, autor, an_publicares, numar_exemplare);
                lista.add(r);
            }
        }
        scfisier.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        List<Publicatie> lista = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        citire(lista);

        do {
            System.out.println("\nMeniu:");
            System.out.println("1. Afiseaza toate publicatiile");
            System.out.println("2. Filtreaza publicatiile dupa anul de publicare");
            System.out.println("3. Afiseaza doar cartile");
            System.out.println("4. Afiseaza doar revistele");
            System.out.println("5. Adauga o noua publicatie");
            System.out.println("6. Afiseaza revista cu cele mai multe exemplare");
            System.out.println("7. Iesire");
            System.out.println("\nAlege o optiune: ");
            int opt = sc.nextInt();

            switch (opt) {
                case 1:
                    lista.forEach(System.out::println);
                    break;

                case 2:
                    System.out.print("Introduceti anul: ");
                    int an = sc.nextInt();

                    lista.stream()
                            .filter(p -> p.getAn_publicare() == an)
                            .forEach(System.out::println);
                    break;

                case 3:
                    lista.stream()
                            .filter(c -> c instanceof Carte)
                            .map(c -> (Carte) c)
                            .forEach(System.out::println);
                    break;

                case 4:
                    lista.stream()
                            .filter(r -> r instanceof Revista)
                            .map(r -> (Revista) r)
                            .forEach(System.out::println);
                    break;
                case 5:
                    System.out.print("Introduceti tipul publicatiei (Carte sau Revista): ");
                    String tip = sc.next();
                    System.out.print("Introduceti titlul: ");
                    String titlu = sc.next();
                    System.out.print("Introduceti autorul: ");
                    String autor = sc.next();

                    int an_publicare = 0000;
                    boolean valid=false;
                    do{
                        System.out.print("Introduceti anul: ");
                        an_publicare = sc.nextInt();

                        if(an_publicare < LocalDate.now().getYear())
                        {
                            valid=true;
                        }
                        else
                        {
                            System.out.println("Anul nu este corect!");
                        }
                    }while(!valid);

                    if (tip.equalsIgnoreCase("Carte"))
                    {
                        System.out.print("Numarul de pagini: ");
                        int numar_pag = Integer.parseInt(sc.next());
                        lista.add(new Carte(titlu, autor, an_publicare, numar_pag));
                        System.out.print("\nCartea a fost adaugata cu succes!\n");
                    }
                    else if (tip.equalsIgnoreCase("Revista"))
                    {
                        System.out.print("Numarul de exemplare: ");
                        int numar_exemplare = Integer.parseInt(sc.next());
                        lista.add(new Revista(titlu, autor, an_publicare, numar_exemplare));
                        System.out.println("\nRevista a fost adaugata cu succes!\n");
                    }
                    break;
                case 6:
                    lista.stream()
                            .filter(r -> r instanceof Revista)
                            .map(r -> (Revista) r)
                            .max((r1, r2) -> Integer.compare(r1.getAn_publicare(), r2.getAn_publicare()))
                            .ifPresentOrElse(
                                    revista -> System.out.println(revista.getTitlu()),
                                    () -> System.out.println("Nu există reviste în colecție.")
                            );
                    break;
                case 7:
                    exit(0);
                    break;
            }
        } while (true);

    }
}
