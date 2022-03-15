package problems.medium;

import java.util.Stack;

public class SimplifyPath {
    /***
     * #71. Simplify Path - MEDIUM
     * https://leetcode.com/problems/simplify-path/
     */
    public String simplifyPath(String path) {
        if(path.length()==0){
            return path;
        }
        String[] pathArray = path.split("/"); // SPLIT (!)
        Stack<String> stack = new Stack<>();

        StringBuilder result = new StringBuilder();
        for(int i = 0; i<pathArray.length; i++){
            String currentStr = pathArray[i];
            if(currentStr.equals("..")&&!stack.isEmpty()){
                stack.pop();
                continue;
            }
            if(currentStr.equals("") || currentStr.equals(".") || currentStr.equals("..")){
                continue;
            }
            stack.add(currentStr);
        }
        while(!stack.isEmpty()){
            String currentStr = stack.pop();
            result.insert(0,"/" + currentStr); //add to the beginning (!)
        }
        if(result.length()==0){
            return "/";
        }

        return result.toString();
    }
}
