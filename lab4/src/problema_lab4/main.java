package problema_lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class main {

    private static void adaugare(List<Echipamente> lista) throws FileNotFoundException {
        Scanner scfisier = new Scanner(new File("lab4/src/problema_lab4/electronice.txt"));
        String linie;
        while(scfisier.hasNextLine())
        {
            linie= scfisier.nextLine();
            String [] valor = linie.split("[;\n]");


        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Echipamente>lista = new ArrayList<Echipamente>();
        boolean run = true;
        while (run)
        {
        System.out.println("Meniu:");
        System.out.println("1. Afişarea tuturor echipamentelor");
        System.out.println("2. Afişarea imprimantelor");
        System.out.println("3. Afişarea copiatoarelor");
        System.out.println("4. Afişarea sistemelor de calcul");
        System.out.println("5. Modificarea stării în care se află un echipament");
        System.out.println("6. Setarea unui anumit mod de scriere pentru o imprimantă");
        System.out.println("7. Setarea unui format de copiere pentru copiatoare");
        System.out.println("8. Instalarea unui anumit sistem de operare pe un sistem de calcul");
        System.out.println("9. Afişarea echipamentelor vândute");
        System.out.println("0. Ieșire");
        System.out.print("Alegeți o opțiune: ");
        int opt;
        opt = sc.nextInt();

        switch (opt) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            case 6:

                break;
            case 7:

                break;
            case 8:

                break;
            case 9:

                break;
            case 0:
                System.out.println("Ieșire din program.");
                exit(0);
            default:
                System.out.println("Opțiune invalidă.");
        }
    }
    }
}
