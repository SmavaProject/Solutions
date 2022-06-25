package problems.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class LowestCommonAncestorOfABinaryTreeII {
    /**
     * 1644. Lowest Common Ancestor of a Binary Tree II
     * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //node, parent
        HashMap<TreeNode, TreeNode> parents = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            if(parents.containsKey(p) && parents.containsKey(q)) break;
            TreeNode parent = stack.pop();
            if(parent.left!=null){
                TreeNode l = parent.left;
                parents.put(l, parent);
                stack.push(l);
            }
            if(parent.right!=null){
                TreeNode r = parent.right;
                parents.put(r, parent);
                stack.push(r);
            }
        }
        if(!parents.containsKey(p) || !parents.containsKey(q)) return null; //either p or 1 is not found

        //put all parents of p in the set
        HashSet<TreeNode> allParentsOfP = new HashSet<>();
        allParentsOfP.add(p);
        while(parents.containsKey(p)){
            TreeNode parentP = parents.get(p);
            allParentsOfP.add(parentP);
            p = parentP;
        }

        //find a parent of q in the set of allParentsOfP
        while(!allParentsOfP.contains(q)){
            TreeNode parentQ = parents.get(q);
            q = parentQ;
        }
        return q;
    }
}
