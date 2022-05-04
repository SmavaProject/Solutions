package problems.easy;

import problems.medium.TreeNode;

public class SameTree {
    /***
     * #100. Same Tree
     * https://leetcode.com/problems/same-tree/
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)return true;
        if(p == null || q==null)return false; //<<<----- (!)
        if(p.val != q.val) return false;

        return (isSameTree(p.left,q.left) && isSameTree(p.right,q.right));

    }
}

/***
 * if(p == null || q==null) return false; //<<<----- (!)
 * NOT
 * if(p.right == null || q.right!=null) return false;
 * if(p.right != null || q.right==null) return false;
 * etc.
 */