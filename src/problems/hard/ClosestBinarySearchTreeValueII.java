package problems.hard;

import problems.medium.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class ClosestBinarySearchTreeValueII {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

    /***
     * #272. Closest Binary Search Tree Value II - Hard
     *
     * https://leetcode.com/problems/closest-binary-search-tree-value-ii/
     */

        public List<Integer> closestKValues(TreeNode root, double target, int k) {
            List<Integer> result = new ArrayList<>();
            PriorityQueue<NodeDiff> pk = new PriorityQueue<NodeDiff>();

            Queue<TreeNode> q = new LinkedList<>();
            if(root!=null){
                q.add(root);
            }
            while(!q.isEmpty()){
                TreeNode currTreeNode = q.poll();
                NodeDiff currDiffNode = new NodeDiff(currTreeNode, Math.abs(currTreeNode.val-target));
                if(pk.size()<k){
                    pk.add(currDiffNode);
                }else{
                    NodeDiff c = pk.peek();
                    if(currDiffNode.diff < c.diff){ //max heap
                        pk.poll();
                        pk.add(currDiffNode);
                    }
                }

                if(currTreeNode.left!=null){
                    q.add(currTreeNode.left);
                }
                if(currTreeNode.right!=null){
                    q.add(currTreeNode.right);
                }
            }

            for (int i = 0; i<k; i++){
                result.add(pk.poll().node.val);
            }
            return result;
        }

        private class NodeDiff implements Comparable<NodeDiff>{
            public TreeNode node;
            public double diff;
            public NodeDiff(TreeNode node, double diff){
                this.node = node;
                this.diff = diff;
            }

            public double getDiff(){
                return this.diff;
            }
            @Override
            public int compareTo(NodeDiff node){
                if(this.getDiff()> node.getDiff()){ //max heap: we will keep only up to K smallest elements
                    return -1;
                }else if (this.getDiff()< node.getDiff()){
                    return 1;
                }else{
                    return 0;
                }

            }
        }
    }
