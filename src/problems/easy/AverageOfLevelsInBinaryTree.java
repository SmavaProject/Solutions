package problems.easy;

import problems.medium.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {
    /**
     * #637 Average of Levels in Binary Tree - EASY
     * https://leetcode.com/problems/average-of-levels-in-binary-tree/
     */

    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null){
            return null;
        }
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            double levelSum = 0;
            for (int i = 0; i< levelSize; i++){
                TreeNode current = queue.poll();
                levelSum += current.val;

                if(current.left!= null) queue.add(current.left);
                if(current.right!=null) queue.add(current.right);
            }
            result.add(Double.valueOf(levelSum/levelSize));
        }

        return result;
    }
}
