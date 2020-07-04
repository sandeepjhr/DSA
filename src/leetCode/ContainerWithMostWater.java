package leetCode;

import java.util.Arrays;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] input = {1,8,6,2,5,4,8,3,7};
       /*1,8,6,2,5,4,8,3,7

        * 1,8,6,2,5,4,8,3,7
        *
        * */
       int maxArea =0;
       int leftIndex=0;
       int rightIndex = input.length-1;
       while(leftIndex<rightIndex){
           int distance = rightIndex-leftIndex;
           int minOfInput = Math.min(input[leftIndex],input[rightIndex]);
          maxArea = Math.max(maxArea,minOfInput*distance) ;
         if(input[leftIndex]<input[rightIndex]){
             leftIndex++;
         }else{
             rightIndex--;
         }
       }

        System.out.println(maxArea);

    }
}
