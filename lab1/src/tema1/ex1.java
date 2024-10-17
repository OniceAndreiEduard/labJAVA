package tema1;

import java.util.Scanner;

//1. Se cere să se scrie un program Java care să calculeze şi să afişeze perimetru şi aria unui
//dreptunghi. Valorile pentru lungime şi lățime se citesc de la tastatura. Sa se adauge un break
//point pe prima linie care citește valoarea unei laturi si din acel punct să se ruleze programul
//linie cu linie urmărind valorile variabilelor în memorie.

public class ex1 {
    public static void main(String[] args) {
            Scanner Scanner = new Scanner(System.in);
            int L,l;
            System.out.print("l= ");
            l=Scanner.nextInt();
            System.out.print("L= ");
            L=Scanner.nextInt();
            System.out.println("Perimetrul= "+(l+L));
            System.out.println("Aria= "+(l*L));
    }
}
