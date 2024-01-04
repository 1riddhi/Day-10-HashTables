import java.util.Map;
import java.util.HashMap;

public class WordCount {

    public static void main(String[] args) {

        Map<String, Integer> wordCount = new HashMap<>();

        String text = "To be or not to be";
        String[] words = cleanAndSplit(text);

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // System.out.println(wordCount);

        for(Map.Entry<String,Integer> entry:wordCount.entrySet()){
            System.out.println(entry.getKey()+": "+entry.getValue());
        }

    }

    public static String[] cleanAndSplit(String text) {
        return text.trim().replace(".", " ").replace("?", " ").split("\\s+");
    }
}
