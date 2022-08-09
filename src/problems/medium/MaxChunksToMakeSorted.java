package problems.medium;

import java.util.Stack;

public class MaxChunksToMakeSorted {
    /***
     * #769. Max Chunks To Make Sorted
     * https://leetcode.com/problems/max-chunks-to-make-sorted/
     */

    public int maxChunksToSorted(int[] arr) {

        if(arr == null || arr.length == 0) return 0;
        if(arr.length == 1) return 1;
        Stack<Integer> stack = new Stack<>();
        int index = 1;
        stack.push(arr[0]);

        while(!stack.isEmpty() && index< arr.length){
            Integer curr = arr[index];
            Integer maxSoFar = curr; // <<<----- this value must be at the end in the stack
            if(stack.peek() <= curr ){
                stack.push(curr);
            }else{
                maxSoFar = stack.peek();
                while(!stack.isEmpty() && stack.peek()> curr){
                    stack.pop();
                }
                stack.push(maxSoFar);
            }

            index++;
        }

        return stack.size();

    }
}
