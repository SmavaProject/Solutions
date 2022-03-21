package problems.medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    /**
     * # 46. Permutations - MEDIUM
     * https://leetcode.com/problems/permutations/
     */

    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        backtrack(nums, result, current, 0);
        return result;
    }
    private void backtrack(int[] nums, ArrayList<List<Integer>> result,ArrayList<Integer> current, int position){
        if(current.size()==nums.length){
            result.add(new ArrayList<Integer>(current));
            return;
        }
        for(int i = 0; i<= current.size(); i++){ //<------ travers through a current array(!!) (build it)
            current.add(i, nums[position]); //<----- put a new element at the position i
            backtrack(nums, result, current, position+1); //<-- traverse through all positions
            current.remove(i); //remove an element at the index i
        }
    }
}

