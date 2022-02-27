package problems.easy;

import problems.medium.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class ClosestBinarySearchTreeValue {
    /***
     * #270. Closest Binary Search Tree Value - Easy
     * https://leetcode.com/problems/closest-binary-search-tree-value/
     */

    public int closestValue(TreeNode root, double target) {

        int closest = Integer.MAX_VALUE;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            double val = node.val;
            double currentDiff = Math.abs(val- target);
            double diff = Math.abs(target - closest);
            if(currentDiff< diff){
                closest = node.val;
            }
            if(node.left!=null && target<node.val){ //<--- !!! not target<node.left.val
                q.add(node.left);
            }
            if (node.right!=null && target>node.val){
                q.add(node.right);
            }

        }

        return closest;
    }

}
