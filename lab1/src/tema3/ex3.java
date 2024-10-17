package tema3;

import java.util.Scanner;

//Să se scrie un program care citește un număr n natural de la tastatură și afișează toți
//divizorii acestuia pe ecran. Dacă numărul este prim se va afișa un mesaj corespunzător.

public class ex3 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n;
            System.out.println("n=");
            n=sc.nextInt();

            boolean prim=true;
            System.out.println("Divizorii lui "+n+" sunt: ");
            for(int i=1;i<n;i++)
            {
                if(n%i==0)
                {
                    System.out.println(i);
                    if(i!=1 && i!=n)
                        prim=false;
                }
            }
            System.out.println();

            if(prim && n>1)
            {
                System.out.println("Numarul este prim! ");
            }
            else if (n>1)
            {
                System.out.println("Numarul nu este prim! ");
            }

        }
}
