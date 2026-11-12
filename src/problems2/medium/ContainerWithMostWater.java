package problems2.medium;

public class ContainerWithMostWater {

    //https://leetcode.com/problems/container-with-most-water/

    public int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length -1;
        while(left<right){
            int len = right -left;
            int h = Math.min(height[left], height[right]);
            int currArea = len*h;
            maxArea = Math.max(maxArea,currArea);

            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }


        return maxArea;
    }

}
