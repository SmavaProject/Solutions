package problems.medium;

public class TrimABinarySearchTree {
    /***
     * #669. Trim a Binary Search Tree
     * https://leetcode.com/problems/trim-a-binary-search-tree/
     * Solution:
     * https://www.youtube.com/watch?v=jwt5mTjEXGc
     */

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root==null) return root;
        /*
         * Если root.val больше максимально допуситмого значения, то мы не "берем" этот node в ответ,
         * а также мы не "берем" его правую часть root.right, тк она точно будет тоже больше high
         * Следовательно, мы просто возвращаем левую часть которую тоже нужно проветить, поэтому мы
         * не просто ее возвращаем return root.left, а вызываем рекурсию
         */
        if(root.val>high){
            return trimBST(root.left, low, high);
        }
        if(root.val<low){
            return trimBST(root.right, low, high);
        }

        /*
         * Значение для root.left будет определено в ходе рекурсивного вызова, выше ^^^
         * когда текущий root.left будет root
         * root.val будет вне диапазона <low, high> мы вернем противоположную часть дерева.
         * Т.е.
         * if(root.val>high) return trimBST(root.left, low, high);
         */
        root.left = trimBST(root.left, low, high);

        root.right = trimBST(root.right, low, high);


        return root;
    }
}

/***
 * Не нужно делать таких проверок и "самостоятельно" переназначать значение для root.left
 *   if(root.left!=null && root.left.val<low){
 *       root.left = root.left.right;
 *   }
 * Переназначение будет происходить в результате рекурсивного вызова
 */
