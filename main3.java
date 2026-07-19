import java.util.*;
import java.util.stream.Collectors;

class Employee {
    String name;
    int salary;

    Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
}

public class main3
{
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("Ravi", 45000),
                new Employee("Anu", 60000),
                new Employee("Kiran", 75000),
                new Employee("Neha", 40000),
                new Employee("Priya", 55000)
        );

        List<String> result = employees.stream()
                .filter(emp -> emp.salary > 50000)
                .map(emp -> emp.name)
                .collect(Collectors.toList());

        System.out.println(result);
    }
}