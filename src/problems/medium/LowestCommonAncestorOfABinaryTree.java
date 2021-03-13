package problems.medium;

/***
 * POST Order traversal
 * Мы traverse дерево POST Order. Могут быть 2 случая:
 * 1) TreeNode p и TreeNode q в левом и правом subtree
 * 2) Какой-то node содержит TreeNode p или TreeNode q в subtree, и является сам TreeNode p или TreeNode q
 *
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/ #236 MEDIUM
 * https://www.youtube.com/watch?v=Z6d-UM7fDMM
 */
public class LowestCommonAncestorOfABinaryTree
{

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root==q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //we checked both left and right and found p and q there. Thus -> root is LCA
        if(left!=null && right!=null){
            return root;
        }


        //this is the case when the node itself is LCA.
        //One value (p or q) is in the subtree, the other value (p or q) is the node itself
        if(left!=null){
            return left;
        }
        if(right!=null){
            return right;
        }

        //if none of the above is the case -> there is no LCA
        return null;
    }
}
