package leetCode;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MostCommonWord {
    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        String paragraph2 = "abc abc? abcd the jeff!";
        String[] banned2 = {"abc","abcd","jeff"};

        System.out.println(mostCommon2(paragraph2, banned2));
    }

    private static String mostCommon(String paragraph, String[] banned){
        paragraph = paragraph.toLowerCase().replaceAll("[^a-z]", " ");// replacing all non alphabet to empty spaces
        for(String ban: banned){
           paragraph = paragraph.replaceAll(ban, ""); // removing all banned words from the string
        }

        paragraph = paragraph.replaceAll("\\s{2,}"," ").trim();// removing extra spaces to a single space
        System.out.println(paragraph);
        HashMap<String, Integer> map = new HashMap<>();
        String[] strs = paragraph.split(" ");
        for(String s : strs){
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        int maxValue = Collections.max(map.values());
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() == maxValue) return entry.getKey();
        }
        return null;
    }

    private static String mostCommon2(String paragraph, String[] banned){
        for(String ban: banned){
            paragraph = paragraph.replaceAll(ban, ""); // removing all banned words from the string
        }
        HashMap<String, Integer> map = new HashMap<>();
        String[] strs = paragraph.toLowerCase().split("\\W+");// Remove all non-alphbetical characters

        for(String s : strs){
                if(s.length()!=0) map.put(s, map.getOrDefault(s, 0)+1);
        }


        int max = 0;
        String result = "";
        for(String word : map.keySet()){
            if(map.get(word) > max){
                max = map.get(word);
                result = word;
            }
        }
        return result;
    }
}
