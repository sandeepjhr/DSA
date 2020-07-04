package ds.sorting;

public class MergeSort {
    public static void main(String[] args) {
        int[] numbers = {23,5,2,8,12,7,16,9};
        System.out.println("Given array: ");
        printArray(numbers);

    }

    private static void printArray(int[] arr){
        for(int i:arr){
            System.out.print(i+" ");
        }
    }

    //private static int[] sortArray(int[] array){

   // }

    private static int[] mergeArray(int[] left, int[] right){
        return new int[] {0,0};
    }

}
