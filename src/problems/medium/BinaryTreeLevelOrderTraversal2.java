package problems.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal2 {

    /**
     * #107 Binary Tree Level Order Traversal II - MEDIUM
     * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
     * Explanation:
     * Reverse Level Order Traversal (easy)
     * https://www.educative.io/courses/grokking-the-coding-interview/m2N6GwARL8r
     *
     */


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null){
            return new LinkedList<List<Integer>>();
        }
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for (int i = 0; i< levelSize; i++){
                TreeNode currNode = queue.poll();
                currentLevel.add(currNode.val);
                if(currNode.left != null)  queue.add(currNode.left);
                if(currNode.right != null) queue.add(currNode.right);
            }
            result.add(0, currentLevel);
        }

        return result;
    }
}
