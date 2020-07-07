package leetCode.ArrayStrings;

public class NeedleHaystack {
    public static void main(String[] args) {

        String haystack= "hello";
        String needle="lo";
        System.out.println("final result= "+stStr2(haystack,needle));
    }

    public static int stStr(String haystack, String needle){
        if(needle.isEmpty()){
            return 0;
        }
        if(needle.length() > haystack.length()){
            return -1;
        }
        for(int i=0;i<haystack.length();i++){
            int tempIndex = i;
            for(int j=0;j<needle.length();j++){
                if(needle.charAt(j) == haystack.charAt(tempIndex)){
                    if(j==needle.length()-1){
                        return i;
                    }
                    if(tempIndex<haystack.length()-1) {
                        tempIndex++;
                    }
                }else{
                    break;
                }
            }
        }
        return -1;
    }
    public static int stStr2(String haystack, String needle){
        int needleLength=needle.length();
        int haystackLength=haystack.length();
        for(int i=0; i<haystackLength-needleLength+1; i++){
            if(haystack.substring(i,i+needleLength).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
