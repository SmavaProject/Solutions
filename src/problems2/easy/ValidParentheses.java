package problems2.easy;

public class ValidParentheses {

    //https://leetcode.com/problems/valid-parentheses/

    public boolean isValid(String s) {

        java.util.HashMap<String, String> map = new java.util.HashMap<>();
        map.put("(", ")");
        map.put("[", "]");
        map.put("{", "}");

        java.util.Stack<String> stack = new java.util.Stack();
        for (int i = 0; i< s.length(); i++){
            String currentChar = String.valueOf (s.charAt(i));
            if (!stack.isEmpty()){
                String stackChar = stack.peek();
                String stackPair = map.get(stackChar);

                if (currentChar.equals(stackPair)){
                    stack.pop();
                } else{
                    stack.push(currentChar);
                }
            }else{
                stack.push(currentChar);
            }
        }

        if (stack.size() == 0){
            return true;
        }else{
            return false;
        }
    }

}
