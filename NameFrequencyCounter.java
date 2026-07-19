import java.util.HashMap;

public class NameFrequencyCounter {
    public static void main(String[] args) {

        String[] names = {
            "Siri", "shivani", "Siri", "lahari",
            "shravya", "shravya", "siri", "shivani"
        };

        HashMap<String, Integer> map = new HashMap<>();

        for (String name : names) {
            name = name.toLowerCase(); // Convert to lowercase
            if (map.containsKey(name)) {
                map.put(name, map.get(name) + 1);
            } else {
                map.put(name, 1);
            }
        }

        System.out.println("Name Frequencies:");
        for (String name : map.keySet()) {
            System.out.println(name + " : " + map.get(name));
        }
    }
}