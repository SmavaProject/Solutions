package problems.medium;

public class InorderSuccessorInBSTII {
    /**
     * #510. Inorder Successor in BST II
     * https://leetcode.com/problems/inorder-successor-in-bst-ii/
     */
    public Node inorderSuccessor(Node node) {
        //node has a right child => go to the right and than go to the left as long as you can.
        if(node.right!=null){
            node = node.right;
            while(node.left!=null){
                node = node.left;
            }
            return node;
        }else{
            //node has no right children. find the node which is the LEFT child of its parent and return the Parent
            while(node!=null){
                Node parent = node.parent;
                if(parent == null) return null;

                if(parent.left == node){
                    return parent;
                }else{
                    node = parent;
                }
            }
        }

        return null;
    }

    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };
}
