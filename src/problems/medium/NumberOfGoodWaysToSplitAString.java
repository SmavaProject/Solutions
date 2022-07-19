package problems.medium;

import java.util.HashMap;
import java.util.HashSet;

public class NumberOfGoodWaysToSplitAString {
    /***
     * #1525. Number of Good Ways to Split a String
     * https://leetcode.com/problems/number-of-good-ways-to-split-a-string/
     */
    public int numSplits(String s) {

        HashSet<Character> forwardSet = new HashSet<>();
        //<index, unique chars>
        HashMap<Integer, int[]> map = new HashMap<>();
        for(int i = 0; i< s.length(); i++){
            Character c = s.charAt(i);
            forwardSet.add(c);
            map.put(i, new int[] {forwardSet.size(), 0});
        }

        HashSet<Character> backwardSet = new HashSet<>();
        for(int i = s.length()-1; i>= 0; i--){
            Character c = s.charAt(i);
            backwardSet.add(c);
            int[] frequencies = map.get(i);
            frequencies[1] = backwardSet.size();
            map.put(i,frequencies);
        }

        int numerOfWaysToSplit = 0;

        for(int i = 1; i< s.length(); i++){
            int[] prevNum = map.get(i-1);
            int[] currNum = map.get(i);

            if(prevNum[0] == currNum[1]){
                numerOfWaysToSplit++;
            }
        }

        return numerOfWaysToSplit;
    }
}
