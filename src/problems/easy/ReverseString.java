package problems.easy;

public class ReverseString {
    /***
     * #344. Reverse String
     * https://leetcode.com/problems/reverse-string/
     */
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length-1;
        while(start<=end){
            char tmp = s[start];
            s[start] = s[end];
            s[end]= tmp;
            start++;
            end--;
        }
    }
}
