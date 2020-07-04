package ds.sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int[] numbers = {12,8,5,7,2};
        for(int i=1; i<numbers.length; i++){
            int current = numbers[i];
            int j = i-1;
            while(j >= 0 && current < numbers[j]){
                int temp = numbers[j];
                numbers[j]=numbers[j+1];
                numbers[j+1]=temp;
                j--;
            }
        }
        for(int ii=0;ii< numbers.length;ii++){
            System.out.println(numbers[ii]);
        }
    }
}
