package leetCode.ArrayStrings;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] input = {0,1,0,2,1,0,1,3,2,1,2,1};
       // int[] input = {3, 0, 0, 2, 0, 4};
        System.out.println(trap(input));
    }

    /**
     *Think in this way:
     * we will calculate the amount of water can be stored on each building
     * --To store water, it need support from 2 sides
     * Support 1 Calculation:-
     * --we will consider extreme left and extreme right building size and whichever is smaller we will calculate
     * the amount of water on top of that building because we know that opposite side there is a taller building which will act as a support1
     * Support 2 Calculation:-
     * and for 2nd support we will get the support immediately next to it i.e the maximum between its height or previous support2
     * Total water above that building = (Support2 - its height) because support1 will not let water to flow out as Support1 is bigger than current building height
     */

    private static int trap(int[] height) {
        if (height.length == 0) return 0;
        int result = 0, support = 0, left = 0, right = height.length - 1;
        while (left < right) {
            int lowerHeight = 0;
            if (height[left] < height[right]) {
                lowerHeight = height[left++];
            } else lowerHeight = height[right--];

            support = Math.max(support, lowerHeight);
            result = result + (support - lowerHeight);
        }

        return result;
    }


}
