package leetCode;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] input = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> output = groupAnagrams(input);
        System.out.println(output);
    }

    private static List<List<String>> groupAnagrams(String[] strs){
       HashMap<String, List<String>> map = new HashMap<>();
       for(String str: strs){
           String origWord = str;
           char[] sortedWordArr = str.toCharArray();
           Arrays.sort(sortedWordArr);
           String sortedWord = new String(sortedWordArr);
           if(map.containsKey(sortedWord)){
               map.get(sortedWord).add(origWord);
           }else{
               List<String> origWordList = new ArrayList<>();
               origWordList.add(origWord);
               map.put(sortedWord,origWordList);
           }
       }

        return new ArrayList<>(map.values());
    }
}
