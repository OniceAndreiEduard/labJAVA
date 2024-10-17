package tema5;

import java.util.Scanner;
import java.util.Random;

//Să se scrie un program care generează aleatoriu un număr întreg cuprins între 0 și 20.
//Programul va determina dacă numărul aparține șirului lui Fobonacci.

public class ex5
{
    public static boolean Fibonacci(int n) {
        // Generăm șirul Fibonacci până la numărul 20
        int a = 0, b = 1, c;
        if (n == a || n == b) {
            return true; // 0 și 1 fac parte din șir
        }
        // Generăm următoarele numere din șir până când depășim 20
        while (true) {
            c = a + b;
            if (c == n) {
                return true; // Dacă numărul este în șir
            }
            if (c > n) {
                return false; // Dacă numărul depășește valoarea lui n
            }
            a = b;
            b = c;
        }
    }
    public static void main(String[] args)
    {
        Random rand = new Random();
        int nr=rand.nextInt(21); //merge si asa nu doar cu +1
        System.out.println("Numarul generat este:"+nr);

        if (Fibonacci(nr))
        {
            System.out.println(nr + " face parte din șirul Fibonacci.");
        }
        else
        {
            System.out.println(nr + " nu face parte din șirul Fibonacci.");
        }
    }
}
