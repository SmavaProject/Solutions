package problems.medium;

import java.util.ArrayList;
import java.util.LinkedList;

public class KthSmallestElementInBSTIterative {
    /***
     * #230 MEDIUM
     * Iterative solution
     https://leetcode.com/problems/kth-smallest-element-in-a-bst/
     */

    public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return 0;
        }

        ArrayList<Integer> elements = new ArrayList<>();

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode current = root.left;

        //Break the loop when the stack is empty AND current==null
        while(stack.size()>0 || current!=null){
            //Step1: add all current.left nodes to the stack
            if(current!=null){
                stack.push(current);
                current = current.left;
            }else{
                //Step 2: when there are no current.left nodes, start processing node from the stack
                TreeNode node = stack.pop();
                elements.add(node.val);
                //Step 3: go to the right subtree.
                current = node.right;
                //Return to Step 1 and repeat
            }


        }
        return elements.get(k-1)!=null ? elements.get(k-1) : 0;

    }
}
