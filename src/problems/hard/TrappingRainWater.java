package problems.hard;

public class TrappingRainWater {
    /***
     * #42. Trapping Rain Water
     * https://leetcode.com/problems/trapping-rain-water/
     */
    //DP solution:
    public int trap(int[] height) {
        int water = 0;
        int[] leftHeigh = new int[height.length];
        leftHeigh[0] = height[0];
        int[] rightHeigh = new int[height.length];
        rightHeigh[height.length-1] = height[height.length-1];

        for(int i = 1; i<height.length; i++){
            leftHeigh[i] = Math.max(leftHeigh[i-1], height[i]);
        }
        for(int i = height.length-2; i>=0; i--){
            rightHeigh[i] = Math.max(rightHeigh[i+1], height[i]);
        }

        for(int i = 0; i<height.length-1; i++){
            int currentWater = Math.min(leftHeigh[i], rightHeigh[i]) - height[i];
            water+= currentWater;
        }
        return water;
    }
}
