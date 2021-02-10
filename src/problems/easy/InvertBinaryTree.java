package problems.easy;

import problems.medium.TreeNode;

/***
 * https://leetcode.com/problems/invert-binary-tree/ #226 EASY
 */
public class InvertBinaryTree
{
    public TreeNode invertTree(TreeNode root) {

        recursion(root);
        return root;
    }
    public void recursion(TreeNode root){
        if (root == null){
            return;
        }

        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;

        recursion(root.right);
        recursion(root.left);

    }
}
