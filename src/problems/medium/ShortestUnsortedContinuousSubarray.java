package problems.medium;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {
    /**
     * 581. Shortest Unsorted Continuous Subarray
     * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
     */
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length==1)return 0;
        int[] copyNums = Arrays.copyOf(nums, nums.length);
        int left = nums.length-1;
        int right = 0;
        Arrays.sort(copyNums);
        for(int i = 0; i< nums.length; i++){
            if(nums[i]!=copyNums[i]){
                left = Math.min(i, left);
                right = Math.max(i, right);
            }
        }


        return right - left < 0 ? 0 : right - left +1;
    }
}
