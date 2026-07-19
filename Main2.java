import java.util.*;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class Main2 {
    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student("Rahul", 75),
                new Student("Anjali", 55),
                new Student("Kiran", 90),
                new Student("Priya", 60),
                new Student("Sneha", 68)
        );

        Student topStudent = students.stream()
                .max(Comparator.comparingInt(s -> s.marks))
                .orElse(null);

        System.out.println("Top Student: " + topStudent.name);
        System.out.println("Marks: " + topStudent.marks);
    }
}