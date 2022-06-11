package problems.easy;

import problems.medium.TreeNode;

public class LowestCommonAncestorOfABinarySearchTree {
    /**
     * #235. Lowest Common Ancestor of a Binary Search Tree
     * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
     * Нужно найти первый node на котором пути для p и q расходятся
     */

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            TreeNode node = root;

            while(node!=null){
                if(node.val < p.val && node.val < q.val){
                    node = node.right;
                }else if(node.val > p.val && node.val > q.val){
                    node = node.left;
                }else{
                    return node;
                }
            }
            return null;
        }
    }