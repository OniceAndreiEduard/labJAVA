package tema1;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static class Parabola
    {
        private int a;
        private int b;
        private int c;

        public Parabola(int a, int b, int c)
        {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        public double[] caculVarf()
        {
            double x=(double) (-b/(2*a));
            double y=(double) ((-(b*b)+4*a*c)/(4*a));
            return new double[]{x,y};
        }
        @Override
        public String toString() {
            return "f(x)= "+a+"x^2 + "+b+"x + "+c;
        }
        public double[] calculMijloc(Parabola p)
        {
            double []v1=this.caculVarf();
            double []v2=p.caculVarf();

            double xm=(v1[0]+v2[0])/2;
            double ym=(v1[1]+v2[1])/2;
            return new double[]{xm,ym};
        }
        public double[] mijlocParabole(Parabola p1, Parabola p2)
        {
            double []v1=p1.caculVarf();
            double []v2=p2.caculVarf();

            double xm=(v1[0]+v2[0])/2;
            double ym=(v1[1]+v2[1])/2;
            return new double[]{xm,ym};
        }
        public double lungsegdr(Parabola p)
        {
            double []v1=this.caculVarf();
            double []v2=p.caculVarf();
            return Math.hypot((v2[0]-v1[0]),(v2[1]-v1[1]));
        }
        public double lungsegdr2(Parabola p, Parabola p1)
        {
            double []v1=p.caculVarf();
            double []v2=p1.caculVarf();
            return Math.hypot((v2[0]-v1[0]),(v2[1]-v1[1]));
        }

    }
    public static void adaugare(List<Parabola> lista) throws FileNotFoundException {
        Scanner scfisier=new Scanner(new File("src/tema1/in.txt"));
        while(scfisier.hasNext())
        {
            Parabola p=new Parabola(scfisier.nextInt(), scfisier.nextInt(), scfisier.nextInt());
            lista.add(p);
        }
        scfisier.close();

    }

    public static void main(String[] args) throws FileNotFoundException {
        List<Parabola> lista=new ArrayList<Parabola>();
        adaugare(lista);
        for(Parabola p:lista)
        {
            System.out.println(p);
        }

        if(lista.size()>=2)
        {
            Parabola p1=lista.get(0);
            Parabola p2=lista.get(1);
            double []mijloc=lista.get(0).mijlocParabole(p1,p2);
            System.out.println("Mijlocul segmentului care uneste varfurile este: "+mijloc[0]+" si "+mijloc[1]);
            double lungime=lista.get(0).lungsegdr2(p1,p2);
            System.out.println("Lungimea segmentului care uneste varfurile este: "+lungime);
        }
    }
}
