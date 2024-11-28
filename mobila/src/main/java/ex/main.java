package ex;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.System.exit;
import static java.lang.System.in;

public class main {

    public static void scriere(Set<Mobilier> lista) {
        try {
            ObjectMapper mapper=new ObjectMapper();
            mapper.activateDefaultTyping(mapper.getPolymorphicTypeValidator());
            File file=new File("C:\\Users\\andre\\IdeaProjects\\labJAVA\\mobila\\src\\main\\resources\\out.json");
            mapper.writeValue(file,lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Set<Mobilier> citire() {
        try {
            File file=new File("C:\\Users\\andre\\IdeaProjects\\labJAVA\\mobila\\src\\main\\resources\\in.json");
            ObjectMapper mapper=new ObjectMapper();
            Set<Mobilier> mobilier = mapper
                    .readValue(file, new TypeReference<Set<Mobilier>>(){});
            return mobilier;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws IOException {

        Set<Mobilier> lista=new HashSet<>(Set.of(
                new Dulap("Ikea",123.02f,5,123.2f),
                new Canapea("Bosch",1500.99f,6,TipCanapea.Clasica)
        ));
        scriere(lista);
        lista.addAll(citire());
        lista.forEach(System.out::println);

        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("\nMeniu");
            System.out.println("1: Citire dulap ");
            System.out.println("2: Afiseaza cel mai scund dulap ");
            System.out.println("3: Afisarea dulapurilor cu inaltimea de peste 120cm si care au 5 rafturi: ");
            System.out.println("4: Iesire");
            System.out.println("Optiunea este: ");

            int opt=sc.nextInt();
            switch (opt) {
                case 1:
                        boolean validare=false;
                        float inaltime=0;
                        int nr_rafturi=0;

                    System.out.println("Producator: ");
                    String producator=sc.next();
                    System.out.println("Pretul: ");
                    float pretul=sc.nextFloat();
                    System.out.println("Nr_Rafturi: ");
                    nr_rafturi=sc.nextInt();
                    System.out.println("Inaltimea: ");
                    inaltime=sc.nextFloat();

                    do{
                        if(inaltime/nr_rafturi < 25)
                        {
                            System.out.println("Distanta prea mica intre rafturi!");
                            System.out.println("Introduceti din nou: ");
                            System.out.println("Nr_Rafturi: ");
                            nr_rafturi=sc.nextInt();
                            System.out.println("Inaltimea: ");
                            inaltime=sc.nextFloat();
                        }
                        else {
                            lista.add(new Dulap(producator,pretul,nr_rafturi,inaltime));
                            validare=true;
                            System.out.println("Dulapul a fost intodus cu succes!\n");
                        }
                    }while(!validare);

                    lista.forEach(System.out::println);
                    break;
                case 2:
                    Dulap.cms_dulap(lista);
                    break;
                case 3:
                    lista.stream()
                            .filter(d->d instanceof Dulap)
                            .map(d->(Dulap)d)
                            .filter(d->d.getNrRafturi()==5 && d.getInaltime()>120)
                            .forEach(System.out::println);
                    break;
                case 4:exit(0);
                    break;
                default:

            }
        }while(true);

    }
}
