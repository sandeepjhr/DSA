package leetCode.ArrayStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
The solution set must not contain duplicate triplets.
* */
public class ThreeSumClass {
    public static void main(String[] args) {
        int[] input1 = {-1, 0, 1, 2, -1, -4}; int[] input2 = {-2,0,0,2,2}; int[] input3 = {0,0,0}; int[] input = {1,1};
        List<List<Integer>> result = threeSum(input1);
        for(List<Integer> r: result){
            System.out.println(r);
        }

    }


    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> output = new ArrayList<>();
        if(nums.length<3){
            return output;
        }

        Arrays.sort(nums); // -4 -1 -1 0 1 2
        for(int i=0; i<nums.length-2; i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
               if(left-1>i && nums[left] == nums[left-1]){
                   left++;
                   continue;
               }
                int sum = nums[i]+nums[left]+nums[right];
                if(sum == 0){
                    List<Integer> tempResult = new ArrayList<>();
                    tempResult.add(nums[i]);
                    tempResult.add(nums[left]);
                    tempResult.add(nums[right]);
                    output.add(tempResult);
                    left++;
                    right--;
                }else if(sum < 0){
                    left++;
                }else{
                    right--;
                }
            }

        }
        return output;
    }
}
