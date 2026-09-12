package problems2.easy;

public class TwoSum {

    //1. Two Sum - EASY https://leetcode.com/problems/two-sum/
    //complexity O(n2)
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i< nums.length-1; i++){
            for (int j = i+1; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    return new int[] {i, j};
                }
            }

        }
        return new int [] {0, 0};
    }

}
