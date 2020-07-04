package gfg;

public class SubarrayGivenSum {
    public static void main(String[] args) {
        int[] input1 = {1, 2, 3, 7, 5};
        int[] input2 = {1 ,2, 3, 4, 5, 6, 7, 8, 9, 10};
        int requiredTotal = 19;
        int[] output = find(input2, requiredTotal);
        System.out.println(output[0] + "  " + output[1]);
    }

    private static int[] find(int[] input, int requiredTotal) {
        if (input[0] == requiredTotal) {
            return new int[]{0, 0};
        }
        for (int i = 0; i < input.length; i++) {
            int left = input[i];
            int j = i;
            int sum = left;
            while (j < input.length - 1) {
                int right = input[j + 1];
                sum = sum + right;
                if (sum == requiredTotal) {
                    return new int[]{i, j + 1};
                }else if(sum > requiredTotal) break;
                j++;
            }
        }
        return new int[]{-1, -1};
    }
}
