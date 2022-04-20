package problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class CreateBinaryTreeFromDescriptions {
    /**
     * #2196. Create Binary Tree From Descriptions - MEDIUM
     * https://leetcode.com/problems/create-binary-tree-from-descriptions/
     */

    public TreeNode createBinaryTree(int[][] descriptions) {
        //<root.val, children>
        HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();

        HashSet<Integer> isNotRoot = new HashSet<>();
        for (int i = 0; i< descriptions.length; i++){
            int child = descriptions[i][1];
            isNotRoot.add(child);

            //put parent and its values into map
            ArrayList<int[]> children = map.getOrDefault(descriptions[i][0], new ArrayList<>());
            children.add(descriptions[i]);
            map.put(descriptions[i][0], children);
        }
        int rootVal = -1;
        for (int i = 0; i< descriptions.length; i++){
            int parent = descriptions[i][0];
            if(!isNotRoot.contains(parent)){
                rootVal = parent;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(map.containsKey(current.val)){
                ArrayList<int[]> children = map.get(current.val);
                for(int[] child: children){
                    TreeNode childNode = new TreeNode(child[1]);
                    if(child[2] == 1){ //left child
                        current.left = childNode;
                    }else{//right child
                        current.right = childNode;
                    }
                    queue.add(childNode);
                }
            }

        }

        return root;

    }
}
