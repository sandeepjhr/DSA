package leetCode.ArrayStrings;

public class MissingNumber {
    public static void main(String[] args) {
        int[] input = {9,6,4,2,3,5,7,0,1};
        System.out.println(findMissingNo(input));
    }

    private static int findMissingNo(int[] nums){
        int missingNumber=0;
        int n = nums.length;
        int totalExpected = n*(n+1)/2;
        int totalActual = 0;
        for(int i=0;i<n;i++){
            totalActual+=nums[i];
        }
        missingNumber = totalExpected-totalActual;

        return missingNumber;
    }
}
