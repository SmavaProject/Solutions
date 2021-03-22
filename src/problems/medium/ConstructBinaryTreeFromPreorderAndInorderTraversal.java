package problems.medium;

/***
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/ #105 MEDIUM
 * https://www.youtube.com/watch?v=GeltTz3Z1rw
 *
 *
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal
{
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //preorder: Root -> Left -> Right
        //inorder: Left -> Root -> Right

        return helper(0, 0, inorder.length-1, preorder, inorder);
    }

    /**
     * TODO:
     * Точнее описать параметры:
     * @param startPreorder
     * @param startInorder
     * @param endInorder
     */
    public TreeNode helper(int startPreorder, int startInorder, int endInorder, int[] preorder, int[] inorder){
        if(startPreorder>preorder.length-1||startInorder>endInorder)
            return null;

        //по определению Root находится на 0-й позиции в preorder
        TreeNode root = new TreeNode(preorder[startPreorder]);

        //найдем индекс для root в inorder
        //он и разобьет inorder на 2 части: Left  и Right
        int rootIndexInInorder = -1;
        for(int i = 0; i<=endInorder; i++){
            if(root.val == inorder[i])
                rootIndexInInorder = i;
        }

        root.left = helper(startPreorder+1,startInorder, rootIndexInInorder-1, preorder, inorder);
        root.right = helper(startPreorder+ rootIndexInInorder-startInorder  + 1 , rootIndexInInorder+1,endInorder, preorder, inorder);

        return root;
    }
}
