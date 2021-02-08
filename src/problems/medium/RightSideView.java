package problems.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/***
 * https://leetcode.com/problems/binary-tree-right-side-view/ #199 MEDIUM
 */
public class RightSideView
{

    /***
     * Right side view - is the list of the MOST RIGHT node on every level.
     * Implement BFS to traverse the levels of the tree
     */

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root==null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        int levelSize = 1;

        while(!queue.isEmpty()){
            //end of level processing. calculate size of next level
            if(levelSize < 1){
                levelSize = queue.size();
            }

            TreeNode currNode = queue.poll();
            //we picked last element of the level
            if(levelSize == 1){
                result.add(currNode.val);
            }

            if(currNode.left!=null){
                queue.offer(currNode.left);
            }
            if(currNode.right!=null){
                queue.offer(currNode.right);
            }
            levelSize--;

        }

        return result;
    }
}
