package problems.medium;

import java.util.Arrays;

public class ThreeSumClosest {
    /***
     * #16. 3Sum Closest - MEDIUM
     * https://leetcode.com/problems/3sum-closest/
     * Solution:
     * Triplet Sum Close to Target (medium)
     * https://www.educative.io/courses/grokking-the-coding-interview/3YlQz7PE7OA
     */
    public int threeSumClosest(int[] nums, int target) {
        int smallestDiff = Integer.MAX_VALUE;

        Arrays.sort(nums);

        for (int i = 0 ; i<nums.length; i++){
            int start = i+1;
            int end = nums.length-1;

            int cInt = nums[i];
            while(start<end){

                int cSt = nums[start];
                int cEn = nums[end];
                int currSum = cInt + cSt+ cEn;
                int currDiff = target - currSum ;
                if(currDiff == 0){
                    return currSum;
                }
                if(Math.abs(currDiff) < Math.abs(smallestDiff)){
                    smallestDiff = currDiff;
                }
                if(currDiff > 0){ // increase numbers, beacuse currSum is too small
                    start++;
                }

                if(currDiff < 0){ // decrease numbers, beacuse currSum is too big
                    end--;
                }

            }
        }
        return target - smallestDiff ;
    }

}
