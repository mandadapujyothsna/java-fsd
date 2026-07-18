import java.util.*;

public class main4 {
    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();
        map.put("Rahul", 75);
        map.put("Anjali", 55);
        map.put("Kiran", 90);

        map.entrySet().stream()
                .map(entry -> entry.getKey())
                .forEach(System.out::println);
    }
}