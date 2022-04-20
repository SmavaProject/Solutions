package problems.medium;

import java.util.ArrayList;
import java.util.Stack;

public class BinarySearchTreeIterator {
    /**
     * # 173. Binary Search Tree Iterator - MEDIUM
     * https://leetcode.com/problems/binary-search-tree-iterator/
     */
    class BSTIterator {
        int pointer;
        ArrayList<TreeNode> list;

        public BSTIterator(TreeNode root) {
            this.list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();

            while(!stack.isEmpty() || root != null){
                while(root!=null){
                    stack.push(root);
                    root = root.left;
                }
                TreeNode c = stack.pop();
                list.add(c);

                root = c.right;
            }
            this.pointer = -1;
        }

        public int next() {
            this.pointer++;
            return this.list.get(this.pointer).val;
        }

        public boolean hasNext() {
            return (pointer<list.size()-1)? true: false;

        }
    }
}
