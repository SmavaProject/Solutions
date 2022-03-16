package problems.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumIII {
    /***
     *# 216. Combination Sum III - MEDIUM
     * Backtracking
     * https://leetcode.com/problems/combination-sum-iii/
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        LinkedList<Integer> curr = new LinkedList<>();


        recursion(k, n, 0, 0, result, curr);


        return result;
    }
    public void recursion(int limitOfNums, int targetSum, int index, int currSum, List<List<Integer>> result, LinkedList<Integer> curr){
        if(curr.size()==limitOfNums && targetSum==currSum){
            result.add(new LinkedList<Integer>(curr));
            return;
        }else if(index==10 || curr.size()==limitOfNums || currSum>targetSum){
            return;
        }

        for (int i = index; i< 9; i++){
            curr.add(i+1); //<--- только добавили элемент в curr. а currSum не поменяли
            recursion(limitOfNums, targetSum, i+1, currSum + i+1, result, curr);

            //backtrack
            curr.removeLast();
            //currSum не нужно уменьшать тк мы ее фактически не увеличивали(!!!)
            //мы просто вызываем рекурсию с "currSum + i+1"
        }

    }
}
