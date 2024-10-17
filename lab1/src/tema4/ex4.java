package tema4;

import java.util.Random;
import java.util.Scanner;

//Să se determine cmmdc a două numere naturale, a căror valoare maximă este 30. Numerele
//vor fi generate aleatoriu cu ajutorul unui obiect de tip Random și metodei nextInt();

public class ex4
{
    public static int cmmdc(int a, int b) {
        while(b!=0)
        {
            int c=b;
            b=a%b;
            a=c;
        }
        return a;
    }

    public static void main(String[] args)
    {
        Random rand=new Random(); //generarea automata

        int numar1=rand.nextInt(30) + 1; //+1 pt a fi un nr intre 1-30
        int numar2=rand.nextInt(30) + 1;

        System.out.println("Numerele generate sunt: " +numar1+ " si " +numar2);
        int CMMDC=cmmdc(numar1,numar2);
        System.out.println("CMMDC este: " + CMMDC);
    }
}
