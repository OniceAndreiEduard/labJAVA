package ex4;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

class Persoana
{
    private String nume;
    private String cnp;

    public Persoana(String nome, String cnp)
    {
        this.nume = nome;
        this.cnp = cnp;
    }

    public String getNume()
    {
        return nume;
    }

    public String getCnp()
    {
        return cnp;
    }

    //Metoda calcul cnp pe baza varstei
    public int getVarsta()
    {
        int an=Integer.parseInt((cnp.substring(1,3)));
        int luna=Integer.parseInt((cnp.substring(3,5)));
        int ziua=Integer.parseInt((cnp.substring(5,7)));

        //Determinam secol pe baza primei cifre din CNP
        int secol;
        char primaCifra=cnp.charAt(0);
        if(primaCifra=='1' || primaCifra=='2')
        {
            secol=1900;
        } else if (primaCifra=='5' || primaCifra=='6')
        {
            secol=2000;
        }
        else {
            return -1;
        }
        an+=secol;

        //Cream data de nastere
        LocalDate dataNasterii=LocalDate.of(an,luna,ziua);
        LocalDate dataCurenta=LocalDate.now();

        //Calculam varsta
        return (int) ChronoUnit.YEARS.between(dataNasterii, dataCurenta);
    }
    @Override
    public String toString()
    {
        return "Nume: "+nume+ ", CNP: "+cnp+", Varsta: "+getVarsta();
    }

    public static boolean valideazaCNP(String cnp) {
        if (cnp.length() != 13) {
            return false; // CNP-ul nu are 13 caractere
        }
        if (!cnp.matches("\\d{13}")) {
            return false; // CNP-ul nu conține doar cifre
        }
        char primaCifra = cnp.charAt(0);
        if (primaCifra != '1' && primaCifra != '2' && primaCifra != '5' && primaCifra != '6') {
            return false; // Prima cifră nu este 1, 2, 5 sau 6
        }

        // Validarea cifrei de control
        int[] coeficienti = {2, 7, 9, 1, 4, 6, 3, 5, 8, 2, 7, 9};
        int suma = 0;
        for (int i = 0; i < 12; i++) {
            suma += Character.getNumericValue(cnp.charAt(i)) * coeficienti[i];
        }
        int cifraControlCalculata = suma % 11;
        if (cifraControlCalculata == 10) {
            cifraControlCalculata = 1;
        }
        int cifraControlReala = Character.getNumericValue(cnp.charAt(12));
        return cifraControlCalculata == cifraControlReala;
    }
}

public class ex4 {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Introduceti numarul de persoane: ");
        int n=sc.nextInt();
        sc.nextLine();//n

        Persoana[] persoane=new Persoana[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Introduceți numele persoanei " + (i + 1) + ":");
            String nume = sc.nextLine();

            String cnp;
            do {
                System.out.print("Introduceți CNP-ul persoanei " + (i + 1) + ":");
                cnp = sc.nextLine();
                if (!Persoana.valideazaCNP(cnp)) {
                    System.out.print("CNP invalid! Încercați din nou.");
                }
            } while (!Persoana.valideazaCNP(cnp));

            persoane[i] = new Persoana(nume, cnp);
        }


        System.out.println("\nInformațiile introduse:");
        for (Persoana p : persoane) {
            System.out.println(p.toString());
        }

        sc.close();

    }
}
