package problems.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    /***
     * # 13. Roman to Integer - EASY
     * https://leetcode.com/problems/roman-to-integer/
     *
     */
    static Map<String, Integer> values = new HashMap<>();

    static {
        values.put("M", 1000);
        values.put("D", 500);
        values.put("C", 100);
        values.put("L", 50);
        values.put("X", 10);
        values.put("V", 5);
        values.put("I", 1);
    }

    public int romanToInt(String s) {
        int sum = 0;

        for (int index = 0; index< s.length(); index++){
            int nextIndex = index<s.length() -1 ? index+1 : index; // <-- determine the index of a next
            String currChar = Character.toString(s.charAt(index)); //<-- convert char to String
            String nextChar = Character.toString(s.charAt(nextIndex));
            if(values.get(currChar) >= values.get(nextChar)){
                sum+= values.get(currChar);
            }else{
                sum-= values.get(currChar);
            }
        }
        return sum;
    }
}
