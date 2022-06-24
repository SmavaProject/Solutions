package problems.easy;

import problems.medium.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    /***
     * 257. Binary Tree Paths
     * https://leetcode.com/problems/binary-tree-paths/
     */
    public List<String> binaryTreePaths(TreeNode root) {
        /*
            StringBuilder sb = new StringBuilder();
            нельзя использовать в рекурсивных функциях, иначе
            не ["1->2->5","1->3"]
            а ["1->2->5","1->2->53"]
        */
        String path = "";
        ArrayList<String> res = new ArrayList<>();

        rec(root, path, res);
        return res;
    }
    private void rec(TreeNode curr, String path, ArrayList<String> res){
        path += String.valueOf(curr.val);
        if(curr.left!=null || curr.right!=null){
            path += "->";
        }else{
            res.add(path);
        }
        if(curr.left!=null){
            rec(curr.left, path, res);
        }
        if(curr.right!=null){
            rec(curr.right, path, res);
        }
    }

}
