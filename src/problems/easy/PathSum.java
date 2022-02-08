package problems.easy;

import problems.medium.TreeNode;

public class PathSum {
    /**
     * #112. Path Sum - EASY
     * https://leetcode.com/problems/path-sum/
     *
     */


    public boolean hasPathSum(TreeNode root, int targetSum) {
        int currentSum = 0;
        return  recursion(root, targetSum, currentSum);
    }

    public boolean recursion(TreeNode node, int targetSum, int currentSum){
        if(node==null){
            return false;
        }
        /*
        Нельзя добавлять оптимизации типа
        if(currentSum > targetSum){
            return false;
        }
        Это не работает для отрицательных значений node.val и targetSum
         */
        currentSum += node.val;
        if (node.left==null && node.right == null){
            return (currentSum == targetSum);
        }

        return  recursion(node.right, targetSum, currentSum) || recursion(node.left, targetSum, currentSum);
    }
}
