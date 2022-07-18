package problems.medium;

public class BinaryTreeUpsideDown {
    /***
     * #156. Binary Tree Upside Down
     * https://leetcode.com/problems/binary-tree-upside-down/
     */

    //Just think about how you can save the tree information
    //you need before changing the tree structure.
    class Solution {
        public TreeNode upsideDownBinaryTree(TreeNode root) {
            TreeNode curr = root;
            TreeNode prev = null;
            TreeNode tmp = null;
            TreeNode next = null;

            while(curr!=null){
                next = curr.left;
                curr.left = tmp; //сохраненный в прошлой итерации curr.right
                tmp = curr.right;
                curr.right = prev; //сохраненный в прошлой итерации node

                prev = curr;
                curr = next;

            }
            return prev;
        }
    }
}
