package problems.easy;

public class ValidPalindrome {
    /***
     * #125. Valid Palindrome - EASY
     * https://leetcode.com/problems/valid-palindrome/
     */
    public boolean isPalindrome(String s) {
        return recursion(0, s.length()-1, s.toLowerCase());
    }

    public boolean recursion(int start, int end, String s){
        if(start>end){
            return true;
        }
        char st = s.charAt(start);
        char en = s.charAt(end);
        if(!Character.isLetterOrDigit(st)){
            return recursion(start+1, end, s);
        }else if(!Character.isLetterOrDigit(en)){
            return recursion(start, end-1, s);
        } else if(st != en){
            return false;
        }else{
            return recursion(start+1, end-1, s);
        }

    }

}
