package problems.easy;

import problems.medium.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {

    /**
     * # 111. Minimum Depth of Binary Tree - EASY
     * https://leetcode.com/problems/minimum-depth-of-binary-tree/
     * BFS solution:
     * https://www.educative.io/courses/grokking-the-coding-interview/3jwVx84OMkO
     */

    public int minDepth(TreeNode root) {
        if (root == null)return 0;

        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            depth++;
            for(int i = 0; i< levelSize; i++){
                TreeNode node = queue.poll();
                if (node.left== null && node.right==null){
                    return depth;
                }
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
        }

        return depth;
    }

}
