package problems.easy;

import problems.medium.TreeNode;

/***
 * https://leetcode.com/problems/diameter-of-binary-tree/
 * DFS, EASY
 * Главная идея - диамерт максимальный у того node, у которого максимальной длинны левый и правый children
 */
public class DiameterOfBinaryTree
{
    int maxDiameter;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0; //если инициализировать =0 вне метода, то будет ошибка
        dfsChildren(root);
        return maxDiameter; //если вернуть dfsChildren(root); то будет ошибка
    }

    public int dfsChildren(TreeNode root){
        if(root==null){
            return 0;
        }

        int leftMax = dfsChildren(root.left);
        int rightMax = dfsChildren(root.right);

        maxDiameter =Math.max(leftMax + rightMax, maxDiameter);

        return Math.max(leftMax, rightMax)+1;

    }
}
