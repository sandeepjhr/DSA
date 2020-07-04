package leetCode;

public class ArrayProductExceptSelf {
    public static void main(String[] args) {
        int[] input = {1,2,3,4};
        int [] result = productExceptSelf(input);
        int ii=0;
        for(int i: result){
            System.out.print(result[ii]+" ");
            ii++;
        }
    }

    private static int[] productExceptSelf(int[] nums){
        int size = nums.length;
        int[] resultArray = new int[size];
        int[] leftProduct = new int[size];
        int[] rightProduct = new int[size];

        leftProduct[0]=1;
        for(int i=1; i<size; i++){
            leftProduct[i]=nums[i-1]*leftProduct[i-1];
        }

        rightProduct[size-1] = 1;
        for(int i = size-2; i>=0; i--){
            rightProduct[i] = nums[i+1] * rightProduct[i+1];
        }

        for(int i=0; i<size;i++){
            resultArray[i] = leftProduct[i]*rightProduct[i];
        }

        return resultArray;
    }
}
