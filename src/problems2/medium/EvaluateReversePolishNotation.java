package problems2.medium;

public class EvaluateReversePolishNotation {
    //https://leetcode.com/problems/evaluate-reverse-polish-notation/

    public int evalRPN(String[] tokens) {

        if(tokens.length == 1){
            return Integer.valueOf(tokens[0]);
        }
        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");

        Stack<Integer> stack = new Stack<>();

        int res = 0;
        for (String s: tokens){
            if(!operators.contains(s)){
                stack.push(Integer.valueOf(s));
            }

            //int curr
            if(operators.contains(s)){

                if(!stack.isEmpty()){

                    int a = stack.pop();
                    int b = stack.pop();
                    if (s.equals("+")){
                        res = a + b;
                    } else if (s.equals("-")){
                        res = b - a; //<<<------
                    } else if (s.equals("*")){
                        res = a * b;
                    } else{
                        res = b / a; //<<<<----
                    }
                    stack.push(res);
                }


            }
        }

        return res;

    }

}
