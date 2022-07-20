package problems.medium;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBST {
    /***
     * #449. Serialize and Deserialize BST
     * https://leetcode.com/problems/serialize-and-deserialize-bst/
     */

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return null;
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int levelSize = q.size();
            for(int i = 0; i< levelSize; i++){
                TreeNode node = q.poll();
                if(node!=null){
                    sb.append(node.val);
                    q.add(node.left);
                    q.add(node.right);
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
        if(data == null || data.length() == 0)return null;
        String[] nodes = data.split(",");
        if(nodes.length<1) return null;
        TreeNode head = new TreeNode(Integer.valueOf(nodes[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(head);

        int index = 1;

        while(!q.isEmpty()){
            int levelSize = q.size();
            for(int i = 0; i< levelSize; i++){
                TreeNode node = q.poll();
                for(int j = index; j< index + 2 && j < nodes.length; j++){ //index +2 ; не index + levelSize; , index + levelSize*2
                    String nodeVal = nodes[j];
                    if(j % 2 == 0){ //right child
                        if(nodeVal.equals("null")){
                            node.right = null;
                        }else{
                            TreeNode rightChild = new TreeNode(Integer.valueOf(nodes[j]));
                            q.add(rightChild);
                            node.right = rightChild;
                        }
                    }else{
                        if(nodeVal.equals("null")){
                            node.left = null;
                        }else{
                            TreeNode leftChild = new TreeNode(Integer.valueOf(nodes[j]));
                            q.add(leftChild);
                            node.left = leftChild;
                        }
                    }


                }
                index +=2;

            }

        }

        return head;
    }
}
