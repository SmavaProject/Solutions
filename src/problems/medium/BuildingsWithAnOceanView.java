package problems.medium;

import java.util.Stack;

public class BuildingsWithAnOceanView {
    /***
     * #1762. Buildings With an Ocean View
     * https://leetcode.com/problems/buildings-with-an-ocean-view/
     */
    public int[] findBuildings(int[] heights) {
        if(heights.length == 1){
            return new int[]{0};
        }
        //store INDEXES in the stack
        Stack<Integer> monoDecreasingStack = new Stack<>();
        monoDecreasingStack.push(0);

        for(int i = 1; i<heights.length; i++){
            Integer curr = heights[i];
            while(!monoDecreasingStack.isEmpty() && heights[monoDecreasingStack.peek()]<=curr){ // <-----  <=curr
                monoDecreasingStack.pop();
            }
            monoDecreasingStack.push(i);
        }
        int[] result = new int[monoDecreasingStack.size()];
        for(int i = monoDecreasingStack.size() -1; i>=0; i--){
            result[i] = monoDecreasingStack.pop();
        }
        return result;
    }
}