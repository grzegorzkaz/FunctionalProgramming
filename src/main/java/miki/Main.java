package miki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        // Przyklad 1

        List<String> imiona = Arrays.asList("Marek", "Krzysztof", "Rafal");

        List<Integer> dlugoscImion = imiona.stream()
                .map(e -> e.length())
                .collect(Collectors.toList());

        System.out.println("Dlugosc imion: " + dlugoscImion);

        // Przyklad 2 (Employee)

        List<Employee> pracownicy = new ArrayList<>();

        pracownicy.add(new Employee("Jacek", 100.00));
        pracownicy.add(new Employee("Krzysztof", 200.00));

        List<Double> pensje = pracownicy.stream()
                .map(e -> e.getPensja())
                .collect(Collectors.toList());

        Double sredniaPensja = pensje.stream()
                .mapToDouble(p -> Double.valueOf(p))
                .average()
                .orElseThrow(() -> new RuntimeException("Cos sie zjebalo"));




        System.out.println("Pracownicy: " + pracownicy);
        System.out.println("Pensje: " + pensje);
        System.out.println("Srednia pensja: " + sredniaPensja);

    }


    static class Employee {

        String imie;
        Double pensja;

        public Employee(String imie, Double pensja) {
            this.imie = imie;
            this.pensja = pensja;
        }

        public String getImie() {
            return imie;
        }

        public Double getPensja() {
            return pensja;
        }
    }
}
