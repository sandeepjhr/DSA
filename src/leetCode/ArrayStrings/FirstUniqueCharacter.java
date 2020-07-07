package leetCode.ArrayStrings;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class FirstUniqueCharacter {
    public static void main(String[] args) {
        String s = "ddef";
        System.out.println(firstUniqu3(s));
    }

    private static int firstUniqChar(String s) {
        /**
         * check if character is present in hashmap then get count of character and increase by 1,
         * if not then put character and count as 1
         */
        if(s == null || s.length()==0) return -1;
        System.out.println('d' - 1);
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c: s.toCharArray()){
            if(map.containsKey(c)){
                int temp = map.get(c)+1;
                map.replace(c,temp);
            }else{
                map.put(c,1);
            }
        }
        for(char c: s.toCharArray()){
            if(map.get(c) ==1){
                return s.indexOf(c);
            }
        }

        return -1;
    }

    private static int firstUniequ2(String s){
        int[] arr = new int[26]; //it will put ZERO in all 26 indexes
        for(char ch : s.toCharArray()) {
            arr[ch-'a'] = arr[ch - 'a']+1; // incrementing the index value by 1
        }
        for(int i=0; i<s.length(); i++){
            if(arr[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }

    private static int firstUniqu3(String s){
        for(char ch: s.toCharArray()){
            if(s.indexOf(ch)== s.lastIndexOf(ch)) return s.indexOf(ch);
        }
        return -1;
    }
}
