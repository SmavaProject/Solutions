package problems.easy;

import java.util.HashMap;

public class LongestPalindrome {
    /***
     * #409. Longest Palindrome
     * https://leetcode.com/problems/longest-palindrome/
     */
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            Integer count = map.getOrDefault(c, 0);
            map.put(c, count +1);
        }

        int numberOfLetters = 0;
        boolean isEvenTaken = false;
        for (Character ch : map.keySet()){
            if(map.get(ch) % 2 == 0){
                numberOfLetters += map.get(ch);
            }else if(map.get(ch) % 2 == 1 && !isEvenTaken){
                numberOfLetters += map.get(ch);
                isEvenTaken = true;
            }else if(map.get(ch) > 1){ //e.g. take 2 of 3 or 4 of 5
                numberOfLetters += map.get(ch) -1;
            }
        }

        return numberOfLetters;
    }
}
