package ex3;

import java.util.Scanner;

public class ex3
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduceti sirul de caractere: ");
        StringBuilder sb=new StringBuilder(sc.nextLine());

        //inserarea sirului
        System.out.print("Introduceti sirul care va fi inserat: ");
        String s_ins=sc.nextLine();
        //chestie
        System.out.print("Introduceti pozitia la care se va insera sirul: ");
        int poz_ins=sc.nextInt();
        sc.nextLine();

        if (poz_ins >=0 && poz_ins < sb.length())
        {
            sb.insert(poz_ins, s_ins);
            System.out.println("Sirul dupa inserare este: " + sb.toString());
        }
        else
        {
            System.out.println("Pozitia de inserare nu este valida!");
        }

        //stergerea unei portiuni de sir
        System.out.print("Introduceti pozitia de inceput a stergerii: ");
        int poz_sterg=sc.nextInt();
        System.out.print("Introduceti numarul de caractere de sters: ");
        int nr_caractere=sc.nextInt();

        if(poz_sterg>=0 && poz_sterg+nr_caractere<sb.length())
        {
            sb.delete(poz_sterg, poz_sterg+nr_caractere);
            System.out.println("Sirul dupa stergere este: " + sb.toString());
        }
        else
        {
            System.out.println("Pozitia de stergere sau nr_caract nu este valid!");
        }
        sc.close();
    }
}
