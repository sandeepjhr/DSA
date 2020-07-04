package ds.searching.binarySearch;

import java.util.Arrays;

public class BinarySearchExample {
    public static void main(String[] args) {
        int[] numbers = {12,8,5,7,2,3,1,6};
        int searchItem = 7;
        int resultIndex=0;
        Arrays.sort(numbers);//1,2,3,5,6,7,8,12
        int first=0, last=numbers.length;
        while(first <= last){
            int mid = (first+last)/2;
            if(mid < numbers.length && numbers[mid]==searchItem){
                resultIndex = mid;
                break;
            }else if(mid < numbers.length && searchItem > numbers[mid]){
                first = mid+1;
            }else{
                last = mid-1;
            }
        }


        System.out.println("Final Index in sorted array is "+resultIndex);
    }

}
