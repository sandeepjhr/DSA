public class HelloWorld {
    public static void main(String[] args){
        System.out.println("Hello World!!!!!!!!!");
        int[] myResult = (twoSum(new int[]{2,7,11,15}, 13));
        System.out.println(myResult[0]+" and "+myResult[1]);
    }
    /*Given nums = [2, 7, 11, 15], target = 18,*/
    public static int[] twoSum(int[] nums, int target){
        for(int i =0; i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("no result");
    }
}

