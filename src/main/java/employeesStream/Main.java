package employeesStream;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        List<Employee> employees = new ArrayList<>(10);

        employees.add(new Employee("Adam",
                "Kowalski",
                "male",
                "VW",
                LocalDate.of(1988, 3, 21),
                2000.00));
        employees.add(new Employee("Tomasz",
                "Nowak",
                "male",
                "Mercedes",
                LocalDate.of(1968, 3, 10),
                4500.00));
        employees.add(new Employee("Marek",
                "Szymkowiak",
                "male",
                "Lidl",
                LocalDate.of(1998, 2, 11),
                3000.00));
        employees.add(new Employee("Andrzej",
                "Gołota",
                "male",
                "12runda",
                LocalDate.of(1960, 3, 3),
                50000.00));
        employees.add(new Employee("Adam",
                "Małysz",
                "male",
                "200metrow",
                LocalDate.of(1972, 12, 25),
                76000.00));
        employees.add(new Employee("Aneta",
                "Tomczak",
                "female",
                "Wyjazdowi",
                LocalDate.of(1990, 4, 20),
                4500.00));
        employees.add(new Employee("Olga",
                "Michałowska",
                "female",
                "Catering",
                LocalDate.of(1985, 3, 15),
                6700.00));
        employees.add(new Employee("Marta",
                "Mądra",
                "female",
                "UAM",
                LocalDate.of(1976, 1, 22),
                5400.00));


        System.out.println("List size: " + employees.size());
        for (Employee a : employees) {
            System.out.println(a.toString());
        }

        System.out.println("\nZarobki 1 z pracowników pracowników: ");
        for (Employee a : employees) {
            if (a.getName().equals("Marek"))
                System.out.println(a.getSalary());
        }


        System.out.println("\nŚrednie zarobki wszystkich pracowników - sposób nr 1: ");
        double suma = 0;
        int licznik = 0;

        for (Employee a : employees) {
            suma += a.getSalary();
            licznik ++;
        }
        System.out.println(suma/licznik);

        System.out.println("\nZwracanie listy zarobków wszystkich pracowników - stream: ");
        List<Double> employees2 = employees.stream()
                .mapToDouble(p -> p.getSalary())
                .boxed()
                .collect(Collectors.toList());

//                .mapToDouble(p -> p.getSalary()).average().orElse(0);
        System.out.println(employees2);

       double employees3 = employees.stream()
                .mapToDouble(p -> p.getSalary())
                .average()
                .orElse(0.00);
        System.out.println("\nŚrednie zarobki wszystkich pracowników - stream" + "\n" + employees3);

        System.out.println("\nŁączne zarobki wszystkich kobiet: ");
        double wmnAvgSalary = employees.stream()
                .filter(a -> a.getSex().equals("female"))
                .mapToDouble(a -> a.getSalary())
                .average()
                .orElse(0);

        System.out.println(Math.round(wmnAvgSalary * 100.0) / 100.0);

        System.out.println("\nSprawdź w jakiej firmie prcuje najlepiej zarabiający pracownik: ");
        employees.stream()
                .sorted((e1, e2) -> (int)e2.getSalary() - (int)e1.getSalary())
                .map(a -> a.getCompanyName())
//                .map(Employee::getCompanyName)
                .findFirst()
                .ifPresent(a -> System.out.println(a));

        System.out.println("\nLista pracowników po 30stce: ");
        List<Employee> employeesUnder30 = employees.stream()
                .filter(a -> a.getBirthDate().getYear() >= 1989)
                .sorted((e1, e2) -> e2.getBirthDate().getYear() - e1.getBirthDate().getYear())
                .collect(Collectors.toList());

        for (Employee e : employeesUnder30) {
            System.out.println(e.getName() + " " + e.getBirthDate());
        }

        System.out.println("\nLista pracowników z podwyżką 10%: ");

        NumberFormat formatter = new DecimalFormat("#0.00");

        employees.stream()
                .forEach(e -> e.setSalary(e.getSalary() * 1.1));
        for (Employee e : employees){
            System.out.println(e.getName() + " " + formatter.format(e.getSalary()));
//            System.out.println(e.getName() + " " + Math.round(e.getSalary() *100.00) / 100.00);
        }
    }
}
