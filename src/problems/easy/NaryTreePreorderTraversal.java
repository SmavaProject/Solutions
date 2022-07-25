package problems.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NaryTreePreorderTraversal {
    /***
     * #589. N-ary Tree Preorder Traversal
     * https://leetcode.com/problems/n-ary-tree-preorder-traversal/
     */

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<Node> stack = new Stack<>();
        stack.add(root);


        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.add(node.val);

            List<Node> nodeChildren = node.children;

            Collections.reverse(nodeChildren); //<<< ----- !!!!
            for (Node c : nodeChildren) {
                stack.push(c);
            }
        }


        return result;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
