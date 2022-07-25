package problems.medium;

import java.util.Stack;

public class ConstructBinarySearchTreeFromPreorderTraversal {
    /***
     * #1008. Construct Binary Search Tree from Preorder Traversal
     * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int index = 1;

        while(index<preorder.length && !stack.isEmpty()){

            TreeNode parent = stack.peek(); //<<--- мы НЕ вынимаем parent из stack, тк мы может дальше будем traverse влево
            TreeNode child = new TreeNode(preorder[index]);

            //adjust the parent
            // мы дошли до right child. вынимаем вне nodes которые меньше
            while(!stack.isEmpty() && stack.peek().val < child.val){
                parent = stack.pop();
            }

            if(child.val<parent.val){
                parent.left = child;
                //stack.push(parent);
            }else{
                parent.right = child;
            }

            stack.push(child);
            index++;
        }


        return root;
    }
}
