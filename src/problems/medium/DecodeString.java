package problems.medium;

import java.util.Stack;

public class DecodeString {
    /***
     * #394. Decode String
     * https://leetcode.com/problems/decode-string/
     */
    public String decodeString(String s) {
        char lBracket = '[';
        char rBracket = ']';

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int index = 0;

        while(index< s.length()){
            Character curr = s.charAt(index);

            if(curr.equals(rBracket)){
                while(!stack.isEmpty()){
                    Character c = stack.pop();
                    if(c.equals(lBracket)){
                        Character prev = stack.peek();
                        if(Character.isDigit(prev)){
                            StringBuilder digitSB = new StringBuilder();
                            while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                                digitSB.insert(0, stack.pop());
                            }

                            Integer num = Integer.parseInt(digitSB.toString());
                            int sbLen = sb.length();
                            for(int i = 1; i< num; i++){
                                for(int j = 0; j< sbLen; j++){
                                    sb.append(sb.charAt(j));
                                }
                            }
                        }

                        for (int i = 0; i< sb.length(); i++){
                            Character ch = sb.charAt(i);
                            stack.push(ch);
                        }
                        sb.setLength(0);

                        break;


                    }else{
                        sb.insert(0, c);
                    }
                }
            }else {
                stack.push(curr);
            }
            index++;
        }

        sb.setLength(0);
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }
}