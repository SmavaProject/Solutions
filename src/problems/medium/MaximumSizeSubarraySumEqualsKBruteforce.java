package problems.medium;

public class MaximumSizeSubarraySumEqualsKBruteforce {

    /****
     * https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/ - MEDIUM # 325
     *  Similar to explanation https://www.educative.io/courses/grokking-the-coding-interview/JPKr0kqLGNP
     *
     *  Brute force does not pass last tests
     *
     */

    public int maxSubArrayLen(int[] nums, int k) {
        int maxSize = 0;
        int currentSize = 0;
        int currentSum = 0;


        for (int startIndex = 0; startIndex< nums.length; startIndex++){
            for (int endIndex = startIndex; endIndex< nums.length; endIndex++){
                currentSum += nums[endIndex];
                if (currentSum == k){
                    currentSize = endIndex - startIndex + 1;
                    maxSize = Math.max(maxSize, currentSize);
                }
            }
            currentSum = 0;
        }


        return maxSize;
    }
}
