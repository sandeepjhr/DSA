package ds.sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int[] numbers = {12,8,5,7,2};
        for(int i=0; i<numbers.length-1; i++){
            int minIndex = i;
            for(int j=i+1;j<numbers.length;j++){
                if(numbers[minIndex] > numbers[j]){
                    minIndex = j;
                }
            }
            int temp =0;
            temp = numbers[i];
            numbers[i]=numbers[minIndex];
            numbers[minIndex]=temp;
        }
        for(int ii=0;ii< numbers.length;ii++){
            System.out.println(numbers[ii]);
        }
    }
}
