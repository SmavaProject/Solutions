package problems.easy;

public class ValidPalindromeII {
    /**
     * 680. Valid Palindrome II - EASY
     * Recursion
     * https://leetcode.com/problems/valid-palindrome-ii/
     */
    public boolean validPalindrome(String s) {
        return recursion(s, 0, s.length()-1, 1);
    }
    private boolean recursion(String s, int start, int end, int remaining){
        if(start>end){
            return true;
        }

        char st = s.charAt(start);
        char en = s.charAt(end);
        if(st!=en){
            if(remaining<1){
                return false;
            }else{
                remaining--;
                return recursion(s, start+1 , end, remaining) || recursion(s, start, end-1, remaining);
            }
        }
        return recursion(s, ++start, --end, remaining);
    }
}
