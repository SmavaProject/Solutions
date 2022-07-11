package problems.medium;

import java.util.Stack;

public class InorderSuccessorInBST {

    /***
     * #285. Inorder Successor in BST
     * https://leetcode.com/problems/inorder-successor-in-bst/
     */

    //works for any tree, not only BST
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        Stack<TreeNode> stack = new Stack<>();

        boolean nodeFound = false;
        while(!stack.isEmpty() || root!=null){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            //process node
            TreeNode node = stack.pop();
            if(nodeFound) return node;

            if(node.equals(p)){
                nodeFound = true;
            }


            root = node.right;
        }

        return null;
    }


    /*
    Очень быстрое решение, использует свойства BST
    https://leetcode.com/problems/inorder-successor-in-bst/solution/
    Смысл в том, что нам даже не нужно собирать все node в Stack, просто если p.val >= root.val то мы отбрасываем все что слева
    а вот если p.val < root.val то возможно мы нашли наш successor
     */
    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {

        TreeNode successor = null;

        while(root!=null){

            if(p.val >= root.val){
                root = root.right;
            }else{
                successor = root;
                root = root.left;
            }

        }

        return successor;
    }

}
