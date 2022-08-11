package problems.medium;

public class PartitionToKEqualSumSubsets {
    /***
     * #698. Partition to K Equal Sum Subsets
     * https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
     * backtracking
     */

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int totalSum = 0;
        for(int n: nums){
            totalSum += n;
        }
        if(totalSum % k != 0) return false;
        int targetSum = totalSum / k;
        Arrays.sort(nums);
        reverse(nums);
        boolean[] taken = new boolean[nums.length];
        return canDivide(nums, targetSum, k, 0, 0, taken);

    }

    private boolean canDivide(int[] nums, int targetSum, int numberOfSubsets, int currSum, int i, boolean[] taken){
        if(currSum == targetSum && numberOfSubsets == 1){
            return true;
        }
        if(currSum == targetSum ){
            numberOfSubsets--;
            currSum = 0;
            i = 0;
            //return canDivide(nums, targetSum, numberOfSubsets -1, 0, 0, taken);
        }

        for(int j = i; j< nums.length; j++){
            //if((nums[j] != 0) && currSum + nums[j] <= targetSum){ setting nums[j] to 0 and back does not work
            if((!taken[j]) && currSum + nums[j] <= targetSum){
                currSum += nums[j];
                taken[j] = true;
                if(canDivide(nums, targetSum, numberOfSubsets, currSum, j+1, taken)){
                    return true;
                }
                //backtrack
                currSum -= nums[j];
                taken[j] = false;

            }
        }
        return false;
    }
    void reverse(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
