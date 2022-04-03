package problems.hard;

import java.util.Collections;
import java.util.HashMap;

public class ValidPalindromeIII {

    /**
     * #1216. Valid Palindrome III - HARD
     * https://leetcode.com/problems/valid-palindrome-iii/
     * Solution similar to:
     * 516. Longest Palindromic Subsequence - MEDIUM
     * https://leetcode.com/problems/longest-palindromic-subsequence/
     */
    public boolean isValidPalindrome(String s, int k) {
        HashMap<String, Integer> subsequences = new HashMap<>();
        recursion(s,0, s.length()-1, subsequences);

        int maxValidPalindrom = Collections.max(subsequences.values());

        return maxValidPalindrom + k >= s.length() ? true : false;
    }

    public int recursion(String s, int start, int end, HashMap<String, Integer> subsequences){
        if(start>end){
            return 0;
        }
        if(start==end){
            return 1;
        }
        char startChar = s.charAt(start);
        char endChar = s.charAt(end);

        String key = start + "-" + end;

        if(!subsequences.containsKey(key)){

            if(startChar!=endChar){
                subsequences.put(key, Math.max(recursion(s,start+1, end, subsequences), recursion(s, start, end-1, subsequences)));

            }else{
                subsequences.put(key, recursion(s,start+1, end-1, subsequences) + 2);
            }
        }
        return subsequences.get(key);
    }
}
