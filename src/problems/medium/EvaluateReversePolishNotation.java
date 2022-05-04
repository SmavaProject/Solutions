package problems.medium;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishNotation {
    /***
     * #150. Evaluate Reverse Polish Notation - MEDIUM
     * https://leetcode.com/problems/evaluate-reverse-polish-notation/
     * STACK
     */
    public int evalRPN(String[] tokens) {
        if(tokens.length==1)return Integer.valueOf(tokens[0]);
        Integer result = null;
        Stack<Integer> stack = new Stack<>();
        //Set<String> chars = ImmutableSet.of("+", "-", "*", "/");
        Set<String> chars = new HashSet<>();
        chars.add("+");
        chars.add("-");
        chars.add("/");
        chars.add("*");
        for (int i = 0; i< tokens.length; i++){
            String token = tokens[i];
            if(!chars.contains(token)){
                stack.push(Integer.valueOf(token));
            }else{

                Integer int2 = stack.pop(); //в таком порядке
                Integer int1 = stack.pop();
                if(token.equals("+")){
                    result = int1 + int2;
                }else if(token.equals("-")){
                    result = int1 - int2 ;
                }else if(token.equals("*")){
                    result = int1 * int2;
                }else if(token.equals("/")){
                    result  = int1 / int2 ;
                }
                stack.push(result); // <<<<<--------------- (!!!)
            }
        }
        return result;
    }
}
