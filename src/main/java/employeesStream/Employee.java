package employeesStream;

import java.time.LocalDate;

public class Employee {

    private String name;
    private String surname;
    private String sex;
    private String companyName;
    private LocalDate birthDate;
    private double salary;


    Employee(String name, String surname, String sex, String companyName, LocalDate birthDate, Double salary){
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.companyName = companyName;
        this.birthDate = birthDate;
        this.salary = salary;
    }


     String getName() {
        return name;
    }

     void setName(String name) {
        this.name = name;
    }

     String getSurname() {
        return surname;
    }

    void setSurname(String surname) {
        this.surname = surname;
    }

    String getSex() {
        return sex;
    }

     void setSex(String sex) {
        this.sex = sex;
    }

     String getCompanyName() {
        return companyName;
    }

     void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

     LocalDate getBirthDate() {
        return birthDate;
    }

     void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

     double getSalary() {
        return salary;
    }

     void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name = '" + name + '\'' +
                ", surname = '" + surname + '\'' +
                ", sex = '" + sex + '\'' +
                ", companyName = '" + companyName + '\'' +
                ", birthDate = " + birthDate +
                ", salary = " + salary +
                '}';
    }
}



