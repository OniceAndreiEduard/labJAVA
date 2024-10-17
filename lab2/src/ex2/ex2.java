package ex2;
/*
2. Fișierul cantec_in.txt conține versurile unui cântec la alegere. Să se scrie un
program care creează fișierul cantec_out.txt, care conține versurile cântecului original dar în
plus în dreptul fiecărui rând sunt afișate numărul de cuvinte de pe rând şi numărul de vocale
de pe fiecare rând. În dreptul rândurilor care se încheie cu o grupare de litere aleasă se va
pune o steluță (*). Rândurile pentru care un număr generat aleator este mai mic decât 0.1 vor
fi scrise cu majuscule (se vor genera aleator numere între 0 şi 1).
Se va defini o clasă Vers, care are o variabilă membră privată un șir de caractere
reprezentând versul și se va dezvolta câte un operator pentru fiecare cerință de mai sus (o
metodă care returnează numărul de cuvinte, o metodă care returnează numărul de vocale, etc).
Se va crea un vector de obiecte de tip Vers care va conține informația preluată din fișierul de
intrare
 */


import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class ex2 {
    public static class Vers
    {
        private String Vers;
        public Vers(String Vers)
        {
            this.Vers = Vers;
        }
        public int numarcuv()
        {
            String[] words = Vers.split("\\s+");
            return words.length;
        }
        public int numarvoc()
        {
            int count=0;
            for (char c : Vers.toLowerCase().toCharArray())
            {
                if ("aeiou".indexOf(c) != -1)
                {
                    count++;
                }
            }
            return count;
        }
        public boolean steluta () throws FileNotFoundException {
            System.out.print("Terminologie: ");
            Scanner sc = new Scanner(System.in);
            String a = sc.nextLine();
            String Vers2 = Vers;
            if(Vers2.endsWith(a))
            {
                return true;
            }
            else return false;
        }
        public String returnVers()
        {
            return Vers;
        }
        public void maj()
        {
            Random rand = new Random();
            float a=rand.nextFloat(1);
            if (a<0.1)
            {
                Vers = Vers.toUpperCase();
            }

        }
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("src/ex2/cantec_in.txt"));
        Writer wr = new FileWriter("src/ex2/cantec_out.txt");
        while (sc.hasNextLine())
        {
            Vers ver = new Vers(sc.nextLine());
            if (ver.steluta()) {
                ver.maj();
                wr.write(ver.returnVers() + "  " + ver.numarcuv() + "  " + ver.numarvoc() + "*" + "\n");
            }
            else {
                ver.maj();
                wr.write(ver.returnVers() + "  " + ver.numarcuv() + "  " + ver.numarvoc() + "\n");
            }
        }
        wr.close();
    }
}