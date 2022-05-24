package problems.hard;

import java.util.Stack;

public class LongestValidParentheses {
    /***
     * #32. Longest Valid Parentheses
     * https://leetcode.com/problems/longest-valid-parentheses/solution/
     */

    //O(n2) практически тк помечаем все элементы в chars как 1
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        int currLen = 0;
        Stack<Integer> stack = new Stack<>();
        int[]chars = new int[s.length()];

        for(int i = 0; i< s.length(); i++){
            Character c = s.charAt(i);
            if(c.equals('(')){
                stack.push(i);
            }else{
                if(!stack.isEmpty()){
                    Integer index = stack.pop();
                    for (int j = index; j<=i; j++){
                        chars[j]= 1;
                    }
                }
            }
        }
        for(int i = 0; i< s.length(); i++){
            if(chars[i]==1){
                currLen++;
            }else{
                maxLen = Math.max(currLen, maxLen);
                currLen=0;
            }
        }
        maxLen = Math.max(currLen, maxLen); //<<-------------- "(()" когда самый длинный участок остается вконце

        return maxLen;
    }
}
