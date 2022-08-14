package problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeSet;

public class BinaryTreeVerticalOrderTraversal {

    /****
     * # 314.Binary Tree Vertical Order Traversal
     * https://leetcode.com/problems/binary-tree-vertical-order-traversal/
     */

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null)return result;

        //the idea is to "assign" a column number to every vertical row. Root is 0, to the left -1, to the right +1
        //<column, node values>
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        //<node, its column>
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));
        while(!queue.isEmpty()){
            Pair<TreeNode, Integer> currentPair = queue.poll();
            ArrayList<Integer> list = map.getOrDefault(currentPair.getValue(), new ArrayList<Integer>());

            TreeNode currentNode = currentPair.getKey();
            list.add(currentNode.val);
            map.put(currentPair.getValue(), list);

            if(currentNode.left!=null)
                queue.offer(new Pair<>(currentNode.left, currentPair.getValue() -1));

            if(currentNode.right!=null)
                queue.offer(new Pair<>(currentNode.right, currentPair.getValue() +1));
        }

        TreeSet<Integer> keys = new TreeSet(map.keySet());
        for(Integer i: keys){
            result.add(map.get(i));
        }
        return result;
    }

    class Pair<K, V> {
        private TreeNode key;
        private Integer value;

        Pair(TreeNode key, Integer value){
            this.key = key;
            this.value = value;
        }

        public Integer getValue(){
            return value;
        }

        public TreeNode getKey(){
            return key;
        }

        // standard getters and setters
    }
}
