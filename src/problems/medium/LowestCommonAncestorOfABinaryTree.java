package problems.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

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
        //рекурсия прервется либо когда мы нашли p или q, либо когда  дошли до конца и не нашли ничего
        //других значений у TreeNode left и TreeNode right быть не может  - или null, или p либо q
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

    ///// SOLUTION #2


    /*
     * Траверсим все дерево TreeNode root до тех пор пока не найдем nodes p, q
     * Находим всех Ancestors для node p и помещаем их в сет
     * Начинаем искать всех Ancestors для node q и проверять не содержится ли какой-то в Ancestors set for node p
     * Если да, то это и есть lowest common
     */
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            HashMap<TreeNode, TreeNode> parents = new HashMap<>();
            parents.put(root, null);

            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

            while(!parents.containsKey(p) || !parents.containsKey(q)){

                TreeNode curr = stack.pop();
                if(curr.left!=null){
                    parents.put(curr.left, curr);
                    stack.push(curr.left);
                }
                if(curr.right!=null){
                    parents.put(curr.right, curr);
                    stack.push(curr.right);
                }

            }

            // Ancestors set for node p
            Set<TreeNode> parentsSet = new HashSet<>();
            while(p!=null){
                parentsSet.add(p);
                p = parents.get(p);
            }

            //the first ancestor of q which we find in parentsSet of p is the lowest common
            while(!parentsSet.contains(q)){
                q = parents.get(q);
            }

            return q;
        }
    }
}

