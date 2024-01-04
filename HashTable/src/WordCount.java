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
            System.out.println("Word: "+entry.getKey()+" , Frequency: "+entry.getValue());
        }

        String paragraph = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";

        words = cleanAndSplit(paragraph);

        HashMap<Integer, Integer> wordFrequencies = new HashMap<>();

        for (String word : words) {
            int hashCode = word.hashCode();
            wordFrequencies.put(hashCode, wordFrequencies.getOrDefault(hashCode, 0) + 1);
        }

        for (HashMap.Entry<Integer, Integer> entry : wordFrequencies.entrySet()) {
            int hashCode = entry.getKey();
            int frequency = entry.getValue();
            System.out.println("Hash Code: " + hashCode + ", Frequency: " + frequency);
        }

        System.out.println("\nBefore removing words :'are, not'\n'"+paragraph);
        
        paragraph=removeAvoidableWord(paragraph);

        System.out.println("\nAfter removing words:'are, not'\n'"+paragraph);


    }

    public static String[] cleanAndSplit(String text) {
        return text.trim().replace(".", " ").replace("?", " ").split("\\s+");
    }

    public static String removeAvoidableWord(String paragraph){
        String[] avoidWords={"are","not"};

        for(String removeWord:avoidWords){
        paragraph = paragraph.replaceAll(removeWord, "");
        }
        return paragraph;

    }
}
