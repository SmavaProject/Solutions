package problems.medium;

import java.util.ArrayList;
import java.util.List;

/***
 * https://leetcode.com/problems/generate-parentheses/ #22 MEDIUM
 */
public class GenerateParentheses
{
    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        recursion("", 0, 0, n, result);
        return result;
    }

    public void recursion(String currentString, int numberOfOpened, int numberOfClosed, int n, List<String> result){
        //base case
        if(currentString.length() == 2*n){
            result.add(currentString);
            return;
        }

        //каждый раз пока не достигли n мы вызываем рекурсию для открытой скобки "("
        // и каждый каз когда открытых скобок больше вызываем ее для закрытой ")"
        if(numberOfOpened<n){
            recursion(currentString + "(", numberOfOpened+1, numberOfClosed, n, result);
        }
        if(numberOfClosed< numberOfOpened){
            recursion(currentString + ")", numberOfOpened, numberOfClosed+1, n, result);
        }
    }
}
