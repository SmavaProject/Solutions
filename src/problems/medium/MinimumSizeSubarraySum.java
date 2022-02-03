package problems.medium;

public class MinimumSizeSubarraySum {
    /***
     *
     * #209 -  https://leetcode.com/problems/minimum-size-subarray-sum/ - MEDIUM
     * Explanation:
     * Smallest Subarray With a Greater Sum (easy)
     * https://www.educative.io/courses/grokking-the-coding-interview/7XMlMEQPnnQ
     *
     */

    public int minSubArrayLen(int target, int[] nums) {
        int arrayStart = 0;
        int minSize = Integer.MAX_VALUE;
        int currentSum = 0;
        int currentSize = 0;

        for (int arrayEnd = 0; arrayEnd < nums.length; arrayEnd++){
            currentSum += nums[arrayEnd];
            while(currentSum>=target){
                currentSize = arrayEnd - arrayStart + 1;
                minSize = Math.min(minSize, currentSize);
                //subtract the first element to check maybe we can get the target without it
                currentSum = currentSum - nums[arrayStart];
                arrayStart++;
            }
        }

        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }

}
