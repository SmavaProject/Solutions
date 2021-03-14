package problems.medium;

/***
 * https://leetcode.com/problems/validate-binary-search-tree/
 * # 98 MEDIUM
 * Binary search tree
 */
public class ValidateBinarySearchTree
{
    /***
     * Конкретно в этой задаче нельзя (root, Integer.MIN_VALUE, Integer.MAX_VALUE) потому что не проходит тест кейсы
     * Но вообще так бы было "красивее"
     */
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    public boolean validate(TreeNode node, Integer min, Integer max){
        if(node==null){
            return true;
        }
        if((min!=null&& node.val<= min) || (max!=null&&node.val>=max)){
            return false;
        }

        //обязательно validate(left) && validate(right),
        // a не по отдельности validate(left); validate(right);
        // потому что иначе рекурсия вернет результат от одного subtree
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }
}
