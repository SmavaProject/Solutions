package problems.easy;

import java.util.HashMap;

public class TwoSum {
    /**
     * #1. Two Sum - EASY
     * https://leetcode.com/problems/two-sum/
     */

    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 0){
            return new int[0];
        }

        int[] result = new int[2];

        //<integer, its index>
        HashMap<Integer, Integer> map = new HashMap<>();

        /*
        Complexity - O(n)
        Extra space for hashmap
         */
        for (int i = 0; i< nums.length; i++){
            int currInt = nums[i];
            if (map.containsKey(target - currInt)){
                result[0] = i;
                result[1] = map.get(target-currInt);
                return result;
            }else{
                map.put(currInt, i);
            }
        }

        return result;
    }
}
