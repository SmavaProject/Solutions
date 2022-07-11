package problems.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    /***
     * #199. Binary Tree Right Side View
     * https://leetcode.com/problems/binary-tree-right-side-view/
     */

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        if(root!=null) q.offer(root);

        while(q.isEmpty()){
            int levelSize = q.size();

            while(levelSize>1){
                TreeNode node = q.poll();
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);

                levelSize--;
            }

            TreeNode last = q.poll();
            if(last.left!=null) q.offer(last.left);
            if(last.right!=null) q.offer(last.right);
            res.add(last.val);
        }

        return res;
    }

}
