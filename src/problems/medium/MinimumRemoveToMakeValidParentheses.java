package problems.medium;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {
/**
 * #1249. Minimum Remove to Make Valid Parentheses - MEDIUM
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 *
 */
public String minRemoveToMakeValid(String s) {
    Stack<Integer> stack = new Stack<>();
    Set<Integer> toRemove = new HashSet<>();


    for (int i=0; i< s.length(); i++){
        Character c = s.charAt(i);
        if(c=='('){ //all '(' are OK at the beginning, but they may not find a pair. Therefore, we add them to the "toRemove" for now
            stack.push(i);
            toRemove.add(i);
        }else if(c==')'){
            if(!stack.isEmpty()){ //a pair for ')' is found, thus - we keep it. and we delete '(' from stack
                toRemove.remove(stack.pop());
            }else{
                toRemove.add(i); //this is ')' without a pair. we will delete it
            }
        }
    }


    StringBuilder sb = new StringBuilder();
    for (int i=0; i< s.length(); i++){
        Character c = s.charAt(i);
        if(!toRemove.contains(i)){
            sb.append(c);
        }
    }

    return sb.toString();
}
}