package ds.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] numbers = {12,8,5,7,2};
        for(int i=0; i<numbers.length-1; i++){
            for(int j=0;j<numbers.length-1-i;j++){
                if(numbers[j]>numbers[j+1]){
                    int temp = numbers[j];
                    numbers[j]=numbers[j+1];
                    numbers[j+1]=temp;
                }
            }
        }
        for(int ii=0;ii< numbers.length;ii++){
            System.out.println(numbers[ii]);
        }
    }
}
