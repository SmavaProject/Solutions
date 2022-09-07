package problems.easy;

import problems.medium.TreeNode;

public class ConstructStringFromBinaryTree {
    /***
     * #606. Construct String from Binary Tree
     * https://leetcode.com/problems/construct-string-from-binary-tree/
     */

    public String tree2str(TreeNode root) {
        if(root == null) return "";

        if(root.left== null && root.right==null){
            return String.valueOf(root.val);
        }
        if(root.right==null){ //<<<<------
            return String.valueOf(root.val) + "(" + tree2str(root.left) + ")";
        }

        return root.val + "(" + tree2str(root.left) + ")" + "(" + tree2str(root.right) + ")";
    }
}
