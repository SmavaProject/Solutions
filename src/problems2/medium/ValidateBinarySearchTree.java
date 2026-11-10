package problems2.medium;

public class ValidateBinarySearchTree {

    //https://leetcode.com/problems/validate-binary-search-tree/description/


    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        return validate(root, null, null);

    }


    public boolean validate(TreeNode root, Integer maxL, Integer minR) {
        if (root == null) return true;

        if (root.left != null && root.left.val >= root.val) return false;
        if (root.left != null && maxL !=null && root.left.val <= maxL) return false;
        if (root.right !=null && root.right.val <= root.val) return false;
        if( root.right !=null && minR !=null && root.right.val >= minR) return false;

        return validate(root.left, maxL, root.val) && validate(root.right, root.val, minR);

    }

}
