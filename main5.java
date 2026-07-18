import java.util.Arrays;
import java.util.List;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class main5
 {
    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student("Rahul", 75),
                new Student("Anjali", 55),
                new Student("Kiran", 90),
                new Student("Priya", 60),
                new Student("Sneha", 68)
        );

        students.stream()
                .filter(student -> student.marks > 60)
                .forEach(student ->
                        System.out.println(student.name + " - " + student.marks));
    }
}