package problems.easy;

import problems.medium.TreeNode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Stack;

public class SecondMinimumNodeInaBinaryTree {
    /***
     * #671. Second Minimum Node In a Binary Tree - EASY
     * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
     */


    public int findSecondMinimumValue(TreeNode root) {
        if(root == null){
            return -1;
        }
        int minRoot = root.val;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>( (i1, i2) -> i2 - i1);
        HashSet<Integer> seen = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(!seen.contains(node.val)){
                seen.add(node.val);

                if(maxHeap.size()<2){
                    maxHeap.add(node.val);
                }else{
                    int secondMin = maxHeap.peek();
                    if(node.val<secondMin){
                        maxHeap.poll();
                        maxHeap.add(node.val);
                    }
                }
            }

            if(node.left!=null){
                /*
                Добавляем только детей тех node, у которых node.val==minRoot
                тк у других будут слишком большие children в которых все равно не будет SecondMinimumValu
                */
                if(node.val==minRoot){ //<--------
                    stack.push(node.left);
                    stack.push(node.right);
                }
            }
        }

        return maxHeap.size()== 2 ? maxHeap.peek() : -1;
    }
}
