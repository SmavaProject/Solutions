package problems.medium;

import java.util.HashMap;

public class LongestIncreasingSubsequence {
    /***
     * #300. Longest Increasing Subsequence - MEDIUM
     * Solution-1:
     * https://leetcode.com/problems/longest-increasing-subsequence/solution/
     * Solution-2:
     * https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/YQ0y0QOJQ69
     */

    // Solution 1: DP bottom-up
    public int lengthOfLIS(int[] nums) {

        int[]dp = new int[nums.length];
        for(int i = 0; i< dp.length; i++){
            dp[i] = 1; //each number in nums is already a sequence of 1 element
        }

        int maxLendth = 1;
        for (int i = 0; i< nums.length; i++){
            for(int j = 0; j< i; j++){//<<<-------------- j<i
                //only when num[j] is smaller than current num[i]
                if(nums[i]>nums[j]){
                    /*
                     * For every number we try one of two options:
                     * 1) take the nums[j] into the seaqunce (и все numbers которые в свою
                     * очередь уже взяты для nums[j], они сохранены в dp[j])
                     * 2) don't take nums[j], stay with current value of dp[i]
                     */
                    dp[i] = Math.max(dp[i], dp[j] +1);
                    maxLendth = Math.max(maxLendth, dp[i]);
                }
            }
        }
        return maxLendth;

    }


    /*
    Solution-2: DP top-down
     */
    public int lengthOfLIS2(int[] nums) {

        HashMap<String, Integer> map = new HashMap<>();
        return recursion(nums, map, 0, -1);

    }

    public int recursion(int[] nums, HashMap<String, Integer> map, int curr, int prev){
        if(curr == nums.length) return 0;

        String key = prev + "-" + curr;
        if(!map.containsKey(key)){
            int val1 = 0;
            //include current index into sequence
            if(prev==-1 || nums[prev]<nums[curr]){
                val1= recursion(nums, map, curr +1, curr) + 1;
            }
            //exclude current index from sequence
            int val2 = recursion(nums, map, curr +1, prev);

            int val = Math.max(val1, val2);
            map.put(key, val);
        }

        return map.get(key);
    }
}
