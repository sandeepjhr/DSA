package leetCode;

import java.util.HashMap;

public class TwoSum {
    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     *
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *
     * Given nums = [2, 7, 11, 15], target = 9,
     *
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     */

    public static void main(String[] args) {
        int[] input2 = {2,7,11,15};
        int requiredTotal = 99;
        int[] output = twoSumFind(input2, requiredTotal);
        System.out.println(output[0] + "  " + output[1]);
    }
    private static int[] twoSumFind(int[] nums, int target){
        HashMap<Integer,Integer> map = new HashMap<>(); // storing value from nums, and index
        for(int i=0; i<nums.length; i++){
            int compliment = target-nums[i];
            if(map.containsKey(compliment)){
                return new int[]{map.get(compliment),i};//it will fetch the value of compliment(key)
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("not found");
    }
}
