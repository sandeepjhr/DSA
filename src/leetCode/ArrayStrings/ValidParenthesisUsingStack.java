package leetCode.ArrayStrings;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidParenthesisUsingStack {
    public static void main(String[] args) {
         String s1 = "()";
         String s2 = "()[]{}";
         String s3 = "(]";
         String s4 = "(})";
        String s5 = "[([]])";
         System.out.println(isValid(s1));
         System.out.println(isValid(s2));
         System.out.println(isValid(s3));
         System.out.println("s4= "+isValid(s4));
        System.out.println("s5= "+isValid(s5));
    }

    private static boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        for(int i=0; i<s.length();i++){
            char currentChar = s.charAt(i);
            String curChar = Character.toString(currentChar);
            if(currentChar == '(' || currentChar == '[' || currentChar == '{'){
                stack.push(curChar);
                continue;
            }
            if(stack.empty()) return false;
            String lastItem = stack.peek();
            if(currentChar == ')'){
                if(lastItem.charAt(0) == '(') stack.pop();
                else return false;
            }
            if(currentChar == '}'){
                if(lastItem.charAt(0) == '{') stack.pop();
                else return false;
            }
            if(currentChar == ']'){
                if(lastItem.charAt(0) == '[') stack.pop();
                else return false;
            }
        }

        return stack.empty();
    }
}
