package problems.medium;

public class NonDecreasingArray {
    /***
     * 665. Non-decreasing Array
     * https://leetcode.com/problems/non-decreasing-array/
     */

    public boolean checkPossibility(int[] nums) {
        if(nums.length<=2) return true;

        boolean canModify = true;
        for(int i = 1; i< nums.length; i++){
            if(nums[i]<nums[i-1]){
                if(!canModify)return false;

                canModify = false;

                if(i>=2 && nums[i-2]<=nums[i]){
                    nums[i-1] = nums[i]; //we can decrease nums[i-1]
                }else if(i>= 2 && nums[i-2] > nums[i]){
                    nums[i] = nums[i-1]; //we must increase nums[i]
                }
            }
        }

        return true;
    }
}
