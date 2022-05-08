package problems.medium;

import java.util.Stack;

public class Pattern132 {
    /***
     * #456. 132 Pattern
     * https://leetcode.com/problems/132-pattern/
     * Monotonic Stack
     * Solution:
     * https://www.youtube.com/watch?v=q5ANAl8Z458&t=479s
     * https://liuzhenglaichn.gitbook.io/algorithm/monotonic-stack
     */
    public boolean find132pattern(int[] nums) {
        if(nums.length<3){
            return false;
        }

        //keep track of the minimal possible value previously seen in the sequence
        int minValueInStack = nums[0];

        Stack<int[]> monoDecreasingStack = new Stack<>();
        monoDecreasingStack.push(new int[] {minValueInStack, nums[0]});

        /*
         * We need to find such value, which is bigger than minValueInStack and
         * smaller than the monoDecreasingStack.
         */
        for(int i = 1; i<nums.length; i++){
            int currInt = nums[i];
            while(!monoDecreasingStack.isEmpty() && monoDecreasingStack.peek()[1]<=currInt){ // <= to avoid equal values
                monoDecreasingStack.pop(); // remove all values smaller than the currentInt. Now value on the top is guaranteed to be bigger than currentInt OR stack is empty
            }
            if(!monoDecreasingStack.isEmpty() && monoDecreasingStack.peek()[0]<currInt){
                return true;//if the currMin is smaller than currInt - we found all values
            }
            monoDecreasingStack.push(new int[] {minValueInStack, currInt});
            minValueInStack = Math.min(minValueInStack, currInt);
        }
        return false;
    }
}

/***
 * keeping minValue in the array like:
 * minValueInStack[i] = Math.min(minValueInStack[i-1], nums[i]);
 * will not work E.g for test: [3,5,0,3,4]. Anwer: [3,5,4]. minValueInStack will look like: [3,3,0,0,0]
 * But when we start poping values from monoDecreasingStack we need to keep track till what index of minValueInStack we poped to return back to 3
 * Otherwise we will end up with minValue equal to 0
 */
