package problems.hard;

import problems.medium.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
    /***
     * #297. Serialize and Deserialize Binary Tree
     * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return null;
        StringBuilder sb = new StringBuilder();
        int levelSize = 1; // <<<<---------------------
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            levelSize = q.size(); //<<<<<<<<<------ (on every level add NULL if the children are not there )
            for(int i = 0; i< levelSize; i++){
                TreeNode curr = q.poll();
                if(curr != null){
                    sb.append(curr.val);
                    q.add(curr.left);
                    q.add(curr.right);
                }else{
                    sb.append("null");
                }
                sb.append(",");
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length()==0)return null;
        String[] nodes = data.split(",");
        if(nodes.length==0)return null;
        String nullStr = "null";
        TreeNode head = new TreeNode(Integer.valueOf(nodes[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(head);
        int levelSize = 1; //<<<<<<<<----------------------
        int index = 1;
        while(!q.isEmpty()){
            levelSize = q.size();
            for (int i = 0; i< levelSize; i++){
                TreeNode curr = q.poll();
                for (int j = index; j< index+2 && j<nodes.length; j++){ // <<<<<<<<<<------binary tree, therefore each node needs 2 children
                    //if value is null - just append null as childred
                    if(nodes[j].equals(nullStr)){
                        if(j % 2 == 0){
                            curr.right = null;
                        }else{
                            curr.left = null;
                        }
                    }else{
                        //if value is a number - create a new TreeNode
                        TreeNode child = new TreeNode(Integer.valueOf(nodes[j]));
                        q.add(child);
                        if(j % 2 == 0){
                            curr.right = child;
                        }else{
                            curr.left = child;
                        }
                    }

                }
                index +=2; // <<<----- shift index (we already appended these nodes: j < index+2)
            }
        }
        return head;
    }
}