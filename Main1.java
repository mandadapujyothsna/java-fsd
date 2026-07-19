import java.util.ArrayList;
import java.util.List;

// ===== Course class with encapsulation =====
class Course {
    // Private fields - no direct access (encapsulation)
    private String courseCode;
    private String courseName;
    private int courseCredits;
    private int totalSeats;
    private int availableSeats;

    // Constructor
    public Course(String courseCode, String courseName, int courseCredits, int totalSeats) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats; // initially all seats are free
    }

    // Getters
    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCourseCredits() {
        return courseCredits;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    // Setters
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseCredits(int courseCredits) {
        if (courseCredits > 0) {
            this.courseCredits = courseCredits;
        } else {
            System.out.println("Credits must be positive.");
        }
    }

    // Check availability
    public boolean isAvailable() {
        return availableSeats > 0;
    }

    // Enroll a student (reduce available seats)
    public boolean enrollStudent() {
        if (isAvailable()) {
            availableSeats--;
            return true;    
        } else {
            System.out.println("No seats available for " + courseName);
            return false;
        }
    }

    // Cancel a student's seat (increase available seats)
    public boolean cancelEnrollment() {
        if (availableSeats < totalSeats) {
            availableSeats++;
            return true;
        } else {
            System.out.println("All seats already free for " + courseName);
            return false;
        }
    }

    @Override
    public String toString() {
        return "Code: " + courseCode + " | Name: " + courseName +
               " | Credits: " + courseCredits +
               " | Seats: " + availableSeats + "/" + totalSeats +
               " | " + (isAvailable() ? "Available" : "Full");
    }
}

// ===== Course Registration System =====
class CourseRegistrationSystem {
    private List<Course> courses;

    public CourseRegistrationSystem() {
        courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
        System.out.println("Course added: " + course.getCourseName());
    }

    public void removeCourse(String courseCode) {
        Course course = findCourse(courseCode);
        if (course != null) {
            courses.remove(course);
            System.out.println("Course removed: " + courseCode);
        } else {
            System.out.println("Course not found: " + courseCode);
        }
    }

    public void displayAllCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }
        System.out.println("---- All Courses ----");
        for (Course c : courses) {
            System.out.println(c);
        }
    }

    public Course findCourse(String courseCode) {
        for (Course c : courses) {
            if (c.getCourseCode().equalsIgnoreCase(courseCode)) {
                return c;
            }
        }
        return null;
    }

    public int calculateTotalCredits() {
        int total = 0;
        for (Course c : courses) {
            total += c.getCourseCredits();
        }
        return total;
    }

    // Register a student into a course (checks availability internally)
    public void registerStudent(String courseCode) {
        Course course = findCourse(courseCode);
        if (course == null) {
            System.out.println("Course not found: " + courseCode);
            return;
        }
        if (course.enrollStudent()) {
            System.out.println("Registered successfully in " + course.getCourseName() +
                    ". Seats left: " + course.getAvailableSeats());
        }
    }

    // Cancel a student's registration
    public void cancelRegistration(String courseCode) {
        Course course = findCourse(courseCode);
        if (course == null) {
            System.out.println("Course not found: " + courseCode);
            return;
        }
        if (course.cancelEnrollment()) {
            System.out.println("Cancelled. Seats now available: " + course.getAvailableSeats());
        }
    }

    // Display only courses that still have seats
    public void displayAvailableCourses() {
        System.out.println("---- Available Courses ----");
        boolean any = false;
        for (Course c : courses) {
            if (c.isAvailable()) {
                System.out.println(c);
                any = true;
            }
        }
        if (!any) {
            System.out.println("No courses currently have open seats.");
        }
    }
}

// ===== Test / Driver class =====
public class Main1 {
    public static void main(String[] args) {
        CourseRegistrationSystem system = new CourseRegistrationSystem();

        system.addCourse(new Course("CS101", "Java Programming", 4, 2)); // only 2 seats
        system.addCourse(new Course("CS102", "Data Structures", 3, 3));
        system.addCourse(new Course("CS103", "Database Systems", 3, 0)); // no seats

        system.displayAllCourses();

        System.out.println("\n--- Registering students ---");
        system.registerStudent("CS101");
        system.registerStudent("CS101");
        system.registerStudent("CS101"); // should fail - full

        System.out.println("\n--- Checking availability ---");
        system.displayAvailableCourses();

        System.out.println("\n--- Cancelling one seat in CS101 ---");
        system.cancelRegistration("CS101");

        system.displayAllCourses();

        System.out.println("\nTotal Credits: " + system.calculateTotalCredits());
    }
}