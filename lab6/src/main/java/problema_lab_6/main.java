package problema_lab_6;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.reverseOrder;


public class main {
    static void scriere(List<Angajat> lista) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        File file = new File("lab6/src/main/resources/angajati.json");
        mapper.writeValue(file, lista);
    }

    static List<Angajat> citire() throws IOException {
        File file = new File("lab6/src/main/resources/angajati.json");
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        List<Angajat> lista = mapper.readValue(file, new TypeReference<List<Angajat>>() {
        });
        return lista;
    }

    public static void main(String[] args) throws IOException {
        List<Angajat> lista = citire();
        //subpunctul 1
        System.out.println("Afisarea angajatilor: ");
        lista.forEach(System.out::println);
        System.out.println("\n");

        //subpunctul 2
        System.out.println("Angajatii care au peste 2500 RON: ");
        lista
                .stream()
                .filter((s) -> s.getSalariul() > 2500)
                .forEach(System.out::println);
        System.out.println("\n");

        //subpunctul 3
        int anul_curent = LocalDate.now().getYear();
        int anul_trecut = anul_curent - 1;
        List<Angajat> aprilie = lista
                .stream()
                .filter((s) -> s.getPostul().contains("sef") || s.getPostul().contains("director"))
                .filter((s) -> s.getData_angajarii().getYear() == anul_trecut)
                .filter((s) -> s.getData_angajarii().getMonth() == Month.APRIL)
                .collect(Collectors.toList());
        System.out.println("Sefi si directori luna aprilie a anului trecut:\n ");
        aprilie.forEach(System.out::println);

        //subpunctul 4
        System.out.println("\n Angajatii care nu sunt sefi sau directori in ordine descrescatoare a salariilor: \n");
        lista
                .stream()
                .filter((s) -> !(s.getPostul().contains("sef") || s.getPostul().contains("director")))
                .sorted(Comparator.comparing(Angajat::getSalariul).reversed())
                .forEach(System.out::println);
        System.out.println("\n");

        //subpunctul 5
        System.out.println("\n Numele angajatilor cu majuscule: \n");
        List<String> nume_majuscule = lista
                .stream()
                .map((s) -> s.getNume().toUpperCase())
                .collect(Collectors.toList());
        nume_majuscule.forEach(System.out::println);

        //subpunctul 6
        System.out.println("\nAfisarea salariilor mai mici de 3000 RON: \n");
        lista
                .stream()
                .map((s) -> s.getSalariul())
                .filter((s) -> s < 3000)
                .forEach(System.out::println);

        //subpunctul 7
        System.out.println("\nAfișarea datelor primului angajat al firmei: \n");
        lista
                .stream()
                .min(Comparator.comparing(Angajat::getData_angajarii))
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println("Nu exista angajati in firma")
                );

        //subpunctul 8
        System.out.println("\nAfișarea de statistici referitoare la salariul angajaților: \n");
        DoubleSummaryStatistics statisticiSalarii = (DoubleSummaryStatistics) lista
                .stream()
                .collect(Collectors.summarizingDouble(Angajat::getSalariul));
        System.out.println("Salariul minim: " + statisticiSalarii.getMin());
        System.out.println("Salariul mediu: " + statisticiSalarii.getAverage());
        System.out.println("Salariul maxim: " + statisticiSalarii.getMax());

        //subpunctul 9
        System.out.println("\nPrintre angajați există cel puțin un “Ion”: ");
        lista
                .stream()
                .map(Angajat::getNume)
                .filter((nume) -> nume.contains("Ion"))
                .findAny()
                .ifPresentOrElse((nume) -> System.out.println("In firma exista un Ion!"),
                        () -> System.out.println(" Nu exista un Ion in firma!")
                );

        //subpunctul 10
        System.out.println("\nAfișarea numărului de persoane care s-au angajat în vara anului precedent: \n");
        int anulprecedent = LocalDate.now().getYear() - 1;
        long nrAngajatiVara = lista
                .stream()
                .filter((s) -> s.getData_angajarii().getYear() == anulprecedent)
                .filter((s) -> {
                    Month luna = s.getData_angajarii().getMonth();
                    return luna == Month.JUNE || luna == Month.AUGUST || luna == Month.JULY;
                })
                .count();

        System.out.println("Numarul de persoana angajate in vara anului precedent sunt: " + nrAngajatiVara);


    }
}
