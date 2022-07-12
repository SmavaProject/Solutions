package problems.easy;

import java.util.Stack;

public class BackspaceStringCompare {
    /**
     * #844. Backspace String Compare
     * https://leetcode.com/problems/backspace-string-compare/
     */
    public boolean backspaceCompare(String s, String t) {

        Stack<Character> stS = new Stack<>();
        Stack<Character> stT = new Stack<>();

        int indexS = 0;
        int indexT = 0;
        while(indexS< s.length()){
            Character c1 = s.charAt(indexS);

            if(c1.equals('#')){
                if(!stS.isEmpty()){
                    stS.pop();
                }
            }else{
                stS.push(c1);
            }

            indexS++;
        }

        while(indexT < t.length()){
            Character c2 = t.charAt(indexT);

            if(c2.equals('#')){
                if(!stT.isEmpty()){
                    stT.pop();
                }
            }else{
                stT.push(c2);
            }
            indexT++;
        }

        if(stS.isEmpty() && stT.isEmpty()) return true;

        if(stS.size()!= stT.size()) return false;

        while(!stS.isEmpty()){

            if(stS.pop() != stT.pop()) return false;
        }
        return true;
    }
}
