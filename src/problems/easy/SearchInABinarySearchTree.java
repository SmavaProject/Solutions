package problems.easy;

import problems.medium.TreeNode;

public class SearchInABinarySearchTree {

    /**
     * # 700. Search in a Binary Search Tree
     * https://leetcode.com/problems/search-in-a-binary-search-tree/
     */

    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null) return null;
        if(val==root.val) return root;

        TreeNode l = searchBST(root.left, val);
        if(l!=null){
            return l;
        }else{
            TreeNode r = searchBST(root.right, val);
            return r;
        }
    }
}
