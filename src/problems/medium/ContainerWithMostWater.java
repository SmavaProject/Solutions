package problems.medium;

public class ContainerWithMostWater {
    /***
     * #11. Container With Most Water
     * https://leetcode.com/problems/container-with-most-water/
     */
    public int maxArea(int[] height) {
        int startIndex = 0;
        int endIndex = height.length -1;
        int maxAreaInt = Integer.MIN_VALUE;
        while(startIndex<endIndex){
            int st = height[startIndex];
            int en = height[endIndex];
            int sq = (endIndex - startIndex) * Math.min(st, en);
            maxAreaInt = Math.max(maxAreaInt, sq);
            if(st<en){
                startIndex++;
            }else{
                endIndex--;
            }
        }
        return maxAreaInt;
    }
}
