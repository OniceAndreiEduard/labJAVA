package exercitiu;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//problema rezolvata de nota 8,5

public class main {
    public static List<Autoturism> citire() throws IOException {
        File file=new File("exercitiul-1-1-json/src/main/resources/autoturisme.json");
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.registerSubtypes(
                new NamedType(Masina.class, "Masina"),
                new NamedType(Motocicleta.class, "Motocicleta")
        );
        List<Autoturism> lista=mapper.readValue(file, new TypeReference<List<Autoturism>>(){});
        return lista;
    }
    public static void scriere(List<Autoturism> lista) throws IOException {
        ObjectMapper mapper=new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        File file=new File("exercitiul-1-1-json/src/main/resources/autoturisme.json");
        mapper.writeValue(file, lista);
    }


    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        //prima data facem asta

        /*List<Autoturism>lista=new ArrayList<>();
        lista.add(new Masina("Audi",Combustibil.motorina,1200,"A3"));
        lista.add(new Motocicleta("Kavasaki",Combustibil.benzina,LocalDate.of(2010,10,03)));
        lista.add(new Motocicleta("Honda",Combustibil.benzina,LocalDate.of(2012,01,13)));
        scriere(lista);*/

        //dupa ce dam run facem asta
        List<Autoturism> lista=citire();

        System.out.println("\nAfisarea colectiei de autoturisme: \n");
        lista.forEach(System.out::println);

        System.out.println("\nDati tipul de combustibil: ");
        Combustibil tipul= Combustibil.valueOf(sc.next());
        System.out.println("\nDatele autoturismelor care au "+tipul+": \n");
        lista.stream()
                .filter(a->a.getCombustibilul().equals(tipul))
                .forEach(System.out::println);

        System.out.println("\nMotocicleta cea mai veche este: \n");
        lista.stream()
                .filter(m->m instanceof Motocicleta)
                .map(m->(Motocicleta)m)
                .min((m1,m2)->m1.getDataFabricatiei().compareTo(m2.getDataFabricatiei()))
                .ifPresentOrElse(System.out::println,
                        ()-> System.out.println("Nu exista motociclete in lista")
                );

    }
}