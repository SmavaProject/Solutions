package problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {
    /***
     * # 90. Subsets II
     * https://leetcode.com/problems/subsets-ii/
     * Solution:
     * Subsets With Duplicates:
     * https://www.educative.io/courses/grokking-the-coding-interview/7npk3V3JQNr
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums.length==0){
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());

        Arrays.sort(nums);

        int pevSize = 0;
        for (int i = 0; i< nums.length; i++){
            int currSize = result.size();
            int currentInt = nums[i];
            if(i!=0 && nums[i-1] == nums[i]){//add a new number to the numbers added in the previous iteration only ,
                for (int j = result.size()-1; j>=currSize- pevSize; j--){
                    ArrayList<Integer> l = new ArrayList<>(result.get(j)); //copy list
                    l.add(currentInt);
                    result.add(l);
                }
            }else{//add a new number to all combinations in the results
                for (int j = 0; j<currSize; j++){
                    ArrayList<Integer> l = new ArrayList<>(result.get(j)); //copy list
                    l.add(currentInt);
                    result.add(l);
                }
                pevSize = currSize;
            }

        }

        return result;
    }
}
