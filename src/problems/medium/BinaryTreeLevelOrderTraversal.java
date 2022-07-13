package problems.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    /**
     * #102. Binary Tree Level Order Traversal
     *  https://leetcode.com/problems/binary-tree-level-order-traversal/
     */

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null)return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int level = q.size();
            List<Integer> levelVals = new ArrayList<>();
            for(int i = 0; i< level; i++){
                TreeNode node = q.poll();
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
                levelVals.add(node.val);
            }
            result.add(levelVals);
        }
        return result;
    }
}