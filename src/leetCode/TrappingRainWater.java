package leetCode;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] input = {0,1,0,2,1,0,1,3,2,1,2,2};
        System.out.println(trap(input));
    }
    private static int trap(int[] height){
      if(height.length == 0) return 0;
      int result = 0, level = 0, left = 0, right = height.length -1;
      while(left < right){
          int lowerHeight = 0;
        if(height[left] < height[right]){
            lowerHeight = height[left++];
        }else lowerHeight = height[right--];

        level = Math.max(level, lowerHeight);
        result = result+(level -lowerHeight);
      }

      return result;
    }
}
