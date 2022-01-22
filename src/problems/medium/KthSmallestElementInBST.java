package problems.medium;

import java.util.ArrayList;

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
}
