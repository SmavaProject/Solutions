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


    // Вариант 2 , чуть дольше но все подробно расписано
    public boolean isValidBST1(TreeNode root) {
        return validate(root, null, null); //to avoid comparison with Integer.MIN_VALUE
    }

    private boolean validate1(TreeNode node, Integer maxLeft, Integer minRight){
        if((maxLeft != null && node.val <= maxLeft) || (minRight!=null && node.val >= minRight)) return false;

        boolean isLeftValid;
        if(node.left!=null){
            isLeftValid = validate(node.left,  maxLeft, node.val);
        }else{
            isLeftValid = true;
        }

        boolean isRightValid;
        if(node.right!=null){
            isRightValid = validate(node.right, node.val, minRight);
        }else{
            isRightValid = true;
        }

        return isLeftValid && isRightValid;
    }
}
