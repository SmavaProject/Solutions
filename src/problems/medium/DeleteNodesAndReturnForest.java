package problems.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DeleteNodesAndReturnForest {
    /***
     * #1110. Delete Nodes And Return Forest
     * https://leetcode.com/problems/delete-nodes-and-return-forest/
     */
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> toDelete = new HashSet();
        for (int i: to_delete){
            toDelete.add(i);
        }
        HashSet<TreeNode> result = new HashSet<>(); // set to store trees of the forest
        result.add(root); // add root to the forest, if root is to be deleted it will be removed later

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode node = q.poll();

            if(toDelete.contains(node.val)){
                result.remove(node); // <<-- remove the node from the forest because it is in the `toDelete` set
                if(node.left!=null) result.add(node.left); // <<-- add children of the node to the forest
                if(node.right!=null) result.add(node.right);
            }

            if(node.left!=null){
                q.offer(node.left);
                if(toDelete.contains(node.left.val)){ //<<-- if a child is to be deleted, cut it off . This way we will have a clean trimmed tree without any nodes to delete
                    // Since we already added the child to the queue, no worries about loosing it, we will process it later
                    node.left = null;
                }
            }
            if(node.right!=null){
                q.offer(node.right);
                if(toDelete.contains(node.right.val)){
                    node.right = null;
                }
            }

        }


        return new ArrayList<TreeNode>(result);

    }
}
