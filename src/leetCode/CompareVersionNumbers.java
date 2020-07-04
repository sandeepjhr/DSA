package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompareVersionNumbers {
    public static void main(String[] args) {
        String s1= "0.1.0";
        String s2= "1.1.1";
        System.out.println(compareVersion(s1, s2));
    }

    private static int compareVersion(String version1, String version2){
        String[] strArr1 = version1.split("\\.");
        String[] strArr2 = version2.split("\\.");
        List<String> list1 = new ArrayList<String>(Arrays.asList(strArr1));
        List<String> list2 = new ArrayList<String>(Arrays.asList(strArr2));

        while(list1.size()<list2.size()){
            list1.add("0");
        }
        while(list1.size()>list2.size()){
            list2.add("0");
        }
        for(int i=0; i<list1.size(); i++){
            int n1 = Integer.parseInt(list1.get(i));
            int n2 = Integer.parseInt(list2.get(i));
            if(n1>n2) return 1;
            else if(n1<n2) return -1;
        }
        return 0;
    }
}
