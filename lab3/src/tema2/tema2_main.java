package tema2;

import java.time.LocalDate;
import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class tema2_main {
    public class Produs
    {
        private String denumire_prod;
        private double pret;
        private int cantitate;
        private LocalDate data_exp;
        private static double incasari = 0;

        public Produs(String denumire_prod, double pret, int cantitate, LocalDate data_exp)
        {
            this.denumire_prod = denumire_prod;
            this.pret = pret;
            this.cantitate = cantitate;
            this.data_exp = data_exp;
        }

        public String getDenumire_prod(){
            return denumire_prod;
        }
        public double getPret(){
            return pret;
        }
        public int getCantitate(){
            return cantitate;
        }
        public LocalDate getData_exp(){
            return data_exp;
        }
        public void setCantitate(int cantitate){
            this.cantitate = cantitate;
        }
        public static double getIncasari()
        {
            return incasari;
        }

        public boolean VindeProdus(int Cantitate_Vanduta)
        {
            if(Cantitate_Vanduta <= cantitate)
            {
                cantitate -= Cantitate_Vanduta;
                incasari+=Cantitate_Vanduta+pret;
                return true;
            }
            return false;
        }
        @Override
        public String toString() {
            return denumire_prod + ", " + pret + ", " + cantitate + ", " + data_exp;
        }

    }


    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
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
            int optiune = scanner.nextInt();

            switch (optiune) {
                case 1:
                    //1afiseazaProduse();
                    break;
                case 2:
                    //afiseazaProduseExpirate();
                    break;
                case 3:
                   // vindeProdus(scanner);
                    break;
                case 4:
                    //afiseazaProdusePretMinim();
                    break;
                case 5:
                    //salveazaProduseCantitateMica(scanner);
                    break;
                case 6:
                    run = false;
                    break;
                default:
                    System.out.println("Optiune invalida!");
            }
        }
        scanner.close();
    }
}
