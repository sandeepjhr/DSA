package leetCode;

public class ReverseString {
    private void reverseString(char[] s){
        int left = 0;
        int right = s.length-1;
        while(left<right){
            char temp = s[left];
            s[left]=s[right];
            s[right]=temp;
            left++;
            right--;
        }
        System.out.println(s);
    }

    public static void main(String[] args) {
        char[] input={'h','e','o'};
        ReverseString o = new ReverseString();
        o.reverseString(input);
    }
}
