package problems.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PascalsTriangle {
    /***
     * # 118. Pascal's Triangle - EASY
     * https://leetcode.com/problems/pascals-triangle/
     */
    public List<List<Integer>> generate(int numRows) {
        if(numRows==0){
            return new ArrayList<List<Integer>>();
        }

        Stack<ArrayList<Integer>> result = new Stack<ArrayList<Integer>>();

        ArrayList<Integer> first = new ArrayList<>();
        first.add(1);
        result.push(first);
        numRows--;
        while(numRows>0){
            ArrayList<Integer> prev = result.peek();

            ArrayList<Integer> curr = new ArrayList<>();
            curr.add(1);
            for (int i = 1; i< prev.size(); i++){
                int c = prev.get(i);
                int p = prev.get(i-1);
                curr.add(c+p);
            }
            curr.add(1);
            result.push(curr);
            numRows--;
        }

        return new ArrayList<>(result);
    }

}
