package problems.medium;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    /***
     * # 113. Path Sum II - MEDIUM
     * https://leetcode.com/problems/path-sum-ii/
     * Solution:
     * All Paths for a Sum:
     * https://www.educative.io/courses/grokking-the-coding-interview/B815A0y2Ajn
     */

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        List<Integer> currentPath = new ArrayList<>();

        recursion(root, targetSum, 0, currentPath, result);

        return result;
    }

    public void recursion(TreeNode node, int targetSum, int currentSum, List<Integer> currentPath, List<List<Integer>> result){
        if(node == null){
            return;
        }
        currentPath.add(node.val);
        currentSum += node.val;

        if(node.left==null && node.right == null && currentSum == targetSum){
            result.add(new ArrayList<>(currentPath));
        }
        recursion(node.left, targetSum, currentSum, currentPath, result);
        recursion(node.right, targetSum, currentSum, currentPath, result);

        /*
        Backtrack!
         */
        currentSum-= node.val;
        currentPath.remove(currentPath.size()-1);
    }
}
