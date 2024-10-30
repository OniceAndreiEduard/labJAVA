package problema_lab4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.exit;
import static problema_lab4.StareEchipamente.valueOf;


public class main {
    public static void adaugare(List<Echipamente> lista) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("lab4/src/problema_lab4/electronice.txt"));
        sc.useDelimiter("[; \n]");
        String line;

        while (sc.hasNextLine()) {
            line = sc.nextLine();
            String[] values = line.split("[;\n]");
            String nume = values[0];
            int nr_inv = Integer.parseInt(values[1]);
            float pret = Float.parseFloat(values[2]);
            String zona_mag = values[3];
            StareEchipamente stare = StareEchipamente.valueOf(values[4]);
            String clasa= values[5];

            if( clasa.equals("Imprimante"))
            {
                float ppm = Float.parseFloat(values[6]);
                String dpi = values[7];
                int pcar = Integer.parseInt(values[8]);
                ModTiparire modTiparire = ModTiparire.valueOf(values[9].toLowerCase());
                Imprimante i = new Imprimante(nume,nr_inv,pret,zona_mag,stare,ppm,dpi,pcar,modTiparire);
                lista.add(i);

            } else if (clasa.equals("Copiatoare")) {
                int pton= Integer.parseInt(values[6]);
                FormatDECopiere format = FormatDECopiere.valueOf(values[7]);
                Copiatoare c = new Copiatoare(nume,nr_inv,pret,zona_mag,stare,pton,format);
                lista.add(c);
            } else if (clasa.equals("SistemeCalcul")) {
                String tip_mon= values[6];
                float vit_proc= Float.parseFloat(values[7]);
                int c_hdd= Integer.parseInt(values[8]);
                SistemeDEOperare sistem = SistemeDEOperare.valueOf(values[9]);
                SistemeCalcul s = new SistemeCalcul(nume,nr_inv,pret,zona_mag,stare,tip_mon,vit_proc,c_hdd,sistem);
                lista.add(s);

            }


        }
    }

    public static void main(String[] args) throws IOException {
        List<Echipamente> lista = new ArrayList<Echipamente>();
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        adaugare(lista);
        int opt;
        while(true) {
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
            System.out.println("10.Serializare");
            System.out.println("11.Deserializare");
            System.out.println("0. Ieșire");
            System.out.print("Alegeți o opțiune: ");
            opt = sc.nextInt();

            switch (opt) {
                case 1:
                    for (Echipamente e : lista) {
                        System.out.println(e.toString());
                    }
                    break;
                case 2:
                    for (Echipamente e : lista) {
                        if (e instanceof Imprimante)
                        {
                            System.out.println(e);
                        }
                    }
                    break;
                case 3:
                    for (Echipamente e : lista) {
                        if (e instanceof Copiatoare)
                        {
                            System.out.println(e);
                        }
                    }
                    break;
                case 4:
                    for (Echipamente e : lista) {
                        if (e instanceof SistemeCalcul)
                        {
                            System.out.println(e);
                        }
                    }
                    break;
                case 5:
                    String aux;
                    System.out.println("Obiectul la care vreti sa schimbati starea:");
                    aux=sc2.nextLine();
                    System.out.println("Starea:");
                    String aux2=sc2.nextLine();
                    for (Echipamente e : lista) {
                        if (e.getDenumire().equals(aux))
                        {
                            e.setStare(valueOf(aux2.toLowerCase()));
                        }
                    }
                    break;
                case 6:
                    System.out.println("Obiectul la care vreti sa schimbati modul de scriere:");
                    aux=sc2.nextLine();
                    System.out.println("Modul de Scriere:");
                    aux2=sc2.nextLine();
                    for (Echipamente e : lista) {
                        if (e instanceof Imprimante)
                        {
                            if (e.getDenumire().equals(aux2))
                                ((Imprimante) e).setMod_tiparire(ModTiparire.valueOf(aux2.toLowerCase()));
                        }
                    }
                    break;
                case 7:
                    System.out.println("Obiectul la care vreti sa schimbati formatul:");
                    aux=sc2.nextLine();
                    System.out.println("Formatul:");
                    aux2=sc2.nextLine();
                    for (Echipamente e : lista) {
                        if (e instanceof Copiatoare)
                        {
                            if (e.getDenumire().equals(aux2))
                                ((Copiatoare) e).setFormat(FormatDECopiere.valueOf(aux2.toLowerCase()));
                        }
                    }
                    break;
                case 8:
                    System.out.println("Obiectul la care vreti sa schimbati sistemul de operare:");
                    aux=sc2.nextLine();
                    System.out.println("Sistemul de operare:");
                    aux2=sc2.nextLine();
                    for (Echipamente e : lista) {
                        if (e instanceof SistemeCalcul)
                        {
                            ((SistemeCalcul) e).setSisteme(SistemeDEOperare.valueOf(aux2.toLowerCase()));
                        }
                    }
                    break;
                case 9:
                    for (Echipamente e : lista) {
                        if(e.getStare()== valueOf("vandut"))
                        {
                            System.out.println(e);
                        }
                    }
                    break;
                case 10:

                    break;
                case 11:
                    break;
                case 0:
                    System.out.println("Ieșire din program.");
                    exit(0);
                    break;
                default:
                    System.out.println("Opțiune invalidă.");
            }


        }
    }
}