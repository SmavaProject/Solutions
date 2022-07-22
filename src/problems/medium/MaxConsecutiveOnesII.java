package problems.medium;

public class MaxConsecutiveOnesII {
    /***
     * #487. Max Consecutive Ones II
     * https://leetcode.com/problems/max-consecutive-ones-ii/
     * Sliding window
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int start = 0;
        int end = 0;
        int maxLen = 0;
        int currLen = 0;
        boolean isZeroFlipped = false;
        while(end< nums.length && start < nums.length){
            //expand the window
            //move end till nums==1 or till you have a 0 to flip
            while(end < nums.length && (nums[end] == 1 || !isZeroFlipped)){
                if(nums[end] == 0){
                    isZeroFlipped = true;
                }
                end++;
                currLen++;
            }
            maxLen = Math.max(maxLen, currLen);

            //now shrink the window
            //move start till you find 0
            while(start < nums.length && nums[start] == 1){
                start++;
                currLen--;
            }
            //move one more position
            isZeroFlipped = false;
            start++;
            currLen--;

        }


        return maxLen;
    }
}