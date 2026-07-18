import java.util.HashMap;
import java.util.Scanner;

public class WordFrequencyCounter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String sentence = sc.nextLine();

        String[] words = sentence.split(" ");

        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {
            if (frequency.containsKey(word)) {
                frequency.put(word, frequency.get(word) + 1);
            } else {
                frequency.put(word, 1);
            }
        }

        System.out.println("\nWord Frequencies:");
        for (String word : frequency.keySet()) {
            System.out.println(word + " : " + frequency.get(word));
        }

        sc.close();
    }
}