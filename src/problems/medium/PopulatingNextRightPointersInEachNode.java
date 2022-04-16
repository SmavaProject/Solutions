package problems.medium;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
    /***
     * # 116. Populating Next Right Pointers in Each Node
     * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
     */
    public Node connect(Node root) {
        if(root==null)return null;
        int nodesInLevel = 1;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node prev = q.poll();
            if(prev.left!=null) q.add(prev.left);
            if(prev.right!=null) q.add(prev.right);
            Node curr = null;
            for(int i = 1; i< nodesInLevel; i++){
                curr = q.poll();
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);

                prev.next = curr;//add the pointer

                prev = curr;
            }
            nodesInLevel = 2* nodesInLevel;
        }
        return root;
    }

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
}
