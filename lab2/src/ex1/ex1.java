package ex1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;
//Fișierul judete_in.txt, conține lista neordonată a județelor din țară. Să se încarce
//datele din fișier într-un tablou de String-uri și să se ordoneze acest tablou cu ajutorul metodei
//sort() din clasa Arrays. Să se returneze pe ce poziție se află în vectorul ordonat un județ
//introdus de la tastatură. Se va utiliza metoda de căutare binară din clasa Arrays.

public class ex1 {
    public static void main(String[] args) throws FileNotFoundException {
        Vector<String> s= new Vector<>(41,1);
        Scanner scfisier = new Scanner(new File("src/ex1/judete_in.txt"));
        Scanner sc=new Scanner(System.in);

        while(scfisier.hasNext()){
            s.add(scfisier.nextLine());
        }
        String[] array = s.toArray(new String[(0)]);
        Arrays.sort(array);
        scfisier.close();

        String a=sc.nextLine();
        System.out.println(Arrays.binarySearch(array,a));
    }
}
