package problems.medium;

import java.util.Stack;

public class ValidParenthesisString {
    /*
     * #678. Valid Parenthesis String
     * https://leetcode.com/problems/valid-parenthesis-string/
     * Solution:
     * https://www.youtube.com/watch?v=KuE_Cn3xhxI
     */

    /*
     * 1) Use 2 stacks for collecting open brackets and stars. Dont collect chars,
     * collect their indexes because the position of * matters
     * 2) Closing brackets are balanced while we traverse the s.length()
     * 3) When we traverse the string, no need to do anything with *, becuase they may be disregarded at the end.
     * Only use * from the star stack when you see ')' and there is no '(' to balance it
     *
     * 4) Stars dont need to be balanced at the end, they can be disregarded
     */

    /*
     * 3 usages of *
     * 1) As '(' when we traverse the String s when there is no open bracket '(' to balance ')'
     * 2) As ')' at the very end, when we done with traversing the String s,
     * and when there are some unbalanced open brackets in the openBracket stack
     * 3) As '' - wen we simply dont care if the star stack is empty or not when we done with traversing the String s
     */

    public boolean checkValidString(String s) {
        Stack<Integer> openBracket = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for(int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            if(c=='('){
                openBracket.push(i);
            }else if(c==')'){
                if(!openBracket.isEmpty()){
                    openBracket.pop();
                }else if(!star.isEmpty()){
                    star.pop();
                }else{
                    return false;
                }
            }else{
                star.push(i);
            }
        }

        //we need to balance open brackets if there are any left
        while(!openBracket.isEmpty()){
            Integer openBrIndex = openBracket.pop();
            if(star.isEmpty()) return false; // there are no stars to balance '('
            Integer startIndex = star.pop();
            //A star must be behind an open bracket: "(" + "*". We cannot balance if they are they other way around: "*" + "("
            if(openBrIndex<startIndex){
                continue;
            }else{
                return false;
            }
        }


        return true;
    }

}