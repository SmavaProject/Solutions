package problems.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/***
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * Binary tree, BFS, MEDIUM #103
 */
public class BinaryTreeZigzagLevelOrderTraversal
{
    /***
     * BFS с небольшими изменениями. Когда ходим по рядам - переключаем left/right toggle
     * также закидываем children nodes сначала в stack, а уже потом в queue, потому что
     * несмотря на toggle они будут в неправильном порядке (тк каждый раз сами nodes и их children
     * нужно собирать в обратную сторону)
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>(); //Queue для BFS
        Stack<TreeNode> currStack = new Stack<TreeNode>(); //Stack
        queue.add(root);
        int levelSize = 1; // <-- подсчет размера уровня
        List<Integer> currResult = new ArrayList<>();
        boolean rightLeft = false; //toggle для переключения: идем вправо/влево

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(rightLeft){
                if(node.right!=null)
                    currStack.add(node.right);
                if(node.left!=null)
                    currStack.add(node.left);
            }else{
                if(node.left!=null)
                    currStack.add(node.left);
                if(node.right!=null)
                    currStack.add(node.right);
            }
            Integer curr  = node.val;
            currResult.add(curr);
            levelSize--;
            if(levelSize==0){
                result.add(new ArrayList(currResult)); //обязательно new ArrayList, чтобы обнулялась переменная
                currResult.clear();

                while(!currStack.isEmpty()){ //перекидываем child nodes из stack в queue
                    queue.add(currStack.pop());
                }
                levelSize = queue.size();
                if(rightLeft){
                    rightLeft = false;
                }else{
                    rightLeft = true;
                }
            }


        }
        return result;

    }
}
