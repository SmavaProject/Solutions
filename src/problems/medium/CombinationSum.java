package problems.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    /**
     * #39. Combination Sum - MEDIUM
     * Backtracking
     * https://leetcode.com/problems/combination-sum/
     * solution
     * https://leetcode.com/problems/combination-sum/discuss/1777569/FULL-EXPLANATION-WITH-STATE-SPACE-TREE-oror-Recursion-and-Backtracking-oror-Well-Explained-oror-C%2B%2B
     */

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        LinkedList<Integer> curr = new LinkedList<>();

        recursion(candidates, target, result, curr,0, 0);
        return result;
    }

    public void recursion(int[]  candidates,int target, List<List<Integer>> result, LinkedList<Integer> curr, int currPosition, int currSum){
        if(currSum==target){
            result.add(new LinkedList<>(curr));
            return;//save the solution and backtrack
        }
        if(currSum > target){ //backtrack
            return;
        }


        for (int i = currPosition; i< candidates.length; ++i){ //try all option for the next level. Candidates are now reduced (e.g. not [2,3,6,7] but [3,6,7]
            curr.add(candidates[i]);
            currSum+= candidates[i];
            recursion(candidates, target, result, curr, i, currSum); //call recursion with i (!!!) because we allow "same number to be chosen an unlimited number of times"
            //backtrack
            curr.removeLast();
            currSum-= candidates[i];
        }
    }
}
