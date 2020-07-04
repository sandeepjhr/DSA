package hackerRank;

import java.util.Arrays;

public class ArrayLeftRotation {
    public static void main(String[] args) {
        int[] a ={1,2,3,4,5};
        int[] result =rotLeft(a,4);
        System.out.println(Arrays.toString(result));
    }

     private static int[] rotLeft(int[] a, int d){
        /* Input is 1 2 3 4 5
           output = 5 1 2 3 4
           so it means we are moving all the item to the right by 1(a.length - d)
        * */
        int size = a.length;
        int positionToShiftRight = size-d;
        int[] output = new int[size];
        for(int i=0; i<size; i++){
            int newIndex = (i+positionToShiftRight)%size;//Moduling otherwise last item will go to right of it which is out of array index
            output[newIndex] = a[i];
        }

        return output;

    }

}
