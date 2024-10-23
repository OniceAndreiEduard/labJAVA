package tema2;

import java.time.LocalDate;
import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class tema2_main {
    public static class Produs {
        private String denumire_prod;
        private double pret;
        private int cantitate;
        private LocalDate data_exp;
        private static double incasari = 0;
        private static List<Produs> lista = new ArrayList<>();

        public Produs(String denumire_prod, double pret, int cantitate, LocalDate data_exp) {
            this.denumire_prod = denumire_prod;
            this.pret = pret;
            this.cantitate = cantitate;
            this.data_exp = data_exp;
        }

        public String getDenumire_prod() {
            return denumire_prod;
        }

        public double getPret() {
            return pret;
        }

        public int getCantitate() {
            return cantitate;
        }

        public LocalDate getData_exp() {
            return data_exp;
        }

        public void setCantitate(int cantitate) {
            this.cantitate = cantitate;
        }

        public static double getIncasari() {
            return incasari;
        }

        public boolean VindeProdus(int Cantitate_Vanduta) {
            if (Cantitate_Vanduta <= cantitate) {
                cantitate -= Cantitate_Vanduta;
                incasari += Cantitate_Vanduta * pret;  // Multiply, not add
                return true;
            }
            return false;
        }

        @Override
        public String toString() {
            return denumire_prod + ", " + pret + ", " + cantitate + ", " + data_exp;
        }

        public static void adaugare_prod(String fisier)
        {
            try (BufferedReader br = Files.newBufferedReader(Paths.get(fisier))) {
                String line;
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                while ((line = br.readLine()) != null) {
                    String[] fields = line.split(",");
                    String denumire = fields[0].trim();
                    double pret = Double.parseDouble(fields[1].trim());
                    int cantitate = Integer.parseInt(fields[2].trim());
                    LocalDate dataExpirarii = LocalDate.parse(fields[3].trim(), formatter);

                    lista.add(new Produs(denumire,pret,cantitate,dataExpirarii));
                }
            } catch (IOException e) {
                System.out.println("Eroare la citirea fisierului: " + e.getMessage());
            }
        }

        public static void afisare_prod() {
            for (Produs prod : lista) {
                System.out.println(prod);
            }
        }

        public static void afisare_prod_exp()
        {
            LocalDate azi=LocalDate.now();
            for(Produs prod : lista)
            {
                if(prod.data_exp.isBefore(azi))  // Changed to "isBefore" to display expired products
                {
                    System.out.println(prod);
                }
            }
        }

        public static void vinde_prod(Scanner sc)
        {
            sc.nextLine(); // Clear the buffer after reading an integer
            System.out.print("Introduceti denumirea produsului: ");
            String denumire = sc.nextLine();
            System.out.print("Introduceti cantitatea care se vinde: ");
            int cantitate = sc.nextInt();

            Produs produs_de_vanzare = null;
            for(Produs prod : lista)
            {
                if(prod.getDenumire_prod().equals(denumire))
                {
                    produs_de_vanzare = prod;
                    break;
                }
            }
            if(produs_de_vanzare != null)
            {
                if(produs_de_vanzare.VindeProdus(cantitate))
                {
                    System.out.println("Produsul a fost vandut");
                    if(produs_de_vanzare.getCantitate() == 0)
                    {
                        lista.remove(produs_de_vanzare);
                        System.out.println("Produsul a fost eliminat din stoc");
                    }
                }
                else
                {
                    System.out.println("Cantitate insuficienta in stoc!");
                }
            }
            else
            {
                System.out.println("Produsul nu exista");
            }
            System.out.println("Incasari totale: " + Produs.getIncasari());
        }

        public static void afisare_prd_pret_minim()
        {
            if(lista.isEmpty())
            {
                System.out.println("Nu exista produse.");
                return;
            }
            double pret_minim = lista.stream().min(Comparator.comparing(Produs::getPret)).get().getPret();
            for(Produs prod : lista)
            {
                if(prod.getPret() == pret_minim)
                {
                    System.out.println(prod);
                }
            }
        }
    }

    public static void main(String[] args)
    {
        Produs.adaugare_prod("C:\\Users\\andre\\IdeaProjects\\lab3\\src\\tema2\\produse.csv");  // Corrected the call

        Scanner sc = new Scanner(System.in);
        boolean run = true;

        while (run) {
            System.out.println("\nMeniu:");
            System.out.println("1. Afisare produse");
            System.out.println("2. Afisare produse expirate");
            System.out.println("3. Vanzare produs");
            System.out.println("4. Afisare produse cu pret minim");
            System.out.println("5. Salvare produse cu cantitate mica");
            System.out.println("6. Iesire");
            System.out.print("Selectati o optiune: ");
            int optiune = sc.nextInt();

            switch (optiune) {
                case 1:
                    Produs.afisare_prod();
                    break;
                case 2:
                    Produs.afisare_prod_exp();
                    break;
                case 3:
                    Produs.vinde_prod(sc);
                    break;
                case 4:
                    Produs.afisare_prd_pret_minim();
                    break;
                case 5:///de implementat salvarea in fisier cu cantitate mica
                    break;
                case 6:
                    run = false;
                    break;
                default:
                    System.out.println("Optiune invalida!");
            }
        }
    }
}
