package problems.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/***
 * https://leetcode.com/problems/find-leaves-of-binary-tree/ #366 MEDIUM
 *
 */
public class FindLeavesOfBinaryTree
{
    /***
     * Мы находим листья, потом как бы "убираем" их и находим листья следующего уровня.
     */
    /***Collect all values in HashMap. Here we store ArrayList<Integer> ready for the result
     * Integer, ArrayList<Integer> - height, list  of node values
     */
    public static HashMap<Integer, ArrayList<Integer>> map;

    public List<List<Integer>> findLeaves(TreeNode root) {
        this.map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        getHeight(root); //recursion

        //post-processing of the map
        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        for (Integer k: keys){
            result.add(map.get(k));
        }

        return result;
    }

    /***
     * find the height of each TreeNode
     * IMPORTANT: height of every Node is MAX of heights of its children!!!
     * IMPORTANT: process leaves in POST-ORDER, because we only know the height of
     * every TreeNode after we know the height of its children!!!
     */
    int getHeight(TreeNode root){
        //1: base case
        if(root == null){
            //return -1 for null. Thus, the leafs will be 0
            return -1;
        }

        //2: recursion
        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);

        //3: Node processing
        int currH = Math.max(leftH, rightH) +1;
        ArrayList<Integer> list = map.getOrDefault(currH, new ArrayList());
        list.add(root.val);
        map.put(currH, list);
        return currH;
    }
}
