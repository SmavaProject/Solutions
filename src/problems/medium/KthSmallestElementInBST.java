package problems.medium;

import java.util.ArrayList;
import java.util.LinkedList;

public class KthSmallestElementInBST {
    /***
     * #230 MEDIUM
        https://leetcode.com/problems/kth-smallest-element-in-a-bst/
     */


    public int kthSmallest(TreeNode root, int k) {

        ArrayList<Integer> elements = new ArrayList<>();
        inorder(root, elements, k);
        return elements.get(k-1);
    }

    public void inorder(TreeNode root, ArrayList<Integer> elements, int k){
        if(root == null){
            return;
        }
        inorder(root.left, elements, k);
        elements.add(root.val);
        //optimization
        if(elements.size() == k){
            return;
        }
        inorder(root.right, elements, k);
    }


    /*
    Iterative solution:
     */
    public int kthSmallestIterative(TreeNode root, int k) {
        if(root == null){
            return 0;
        }

        ArrayList<Integer> elements = new ArrayList<>();

        LinkedList<TreeNode> stack = new LinkedList<>();

        while(true){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            TreeNode c = stack.pop();
            elements.add(c.val);
            root = c.right;
            if(stack.isEmpty() && root==null)break;
        }
        return elements.size()>=k ? elements.get(k-1) : 0;

    }
}
