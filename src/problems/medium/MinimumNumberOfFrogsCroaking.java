package problems.medium;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class MinimumNumberOfFrogsCroaking {
    /***
     * #1419. Minimum Number of Frogs Croaking
     * https://leetcode.com/problems/minimum-number-of-frogs-croaking/
     */

    public int minNumberOfFrogs(String croakOfFrogs) {
        if(croakOfFrogs.length() % 5 != 0) return -1;

        int minNumberOfFrogs = -1;
        int currNumberOfFrogs = -1;

        HashMap<Character, Integer> map = new LinkedHashMap<>();
        map.put('c', 0);
        map.put('r', 0);
        map.put('o', 0);
        map.put('a', 0);
        map.put('k', 0);

        for(int i = 0; i< croakOfFrogs.length(); i++){
            Character c = croakOfFrogs.charAt(i);
            map.put(c, map.get(c) + 1);

            currNumberOfFrogs = map.get('c');
            minNumberOfFrogs = Math.max(minNumberOfFrogs, currNumberOfFrogs);

            int prevNumOfChars = currNumberOfFrogs;
            for(Character ch : map.keySet()){ //check whether all chars are in order
                int currNum = map.get(ch);
                if(currNum > prevNumOfChars) return -1;

                prevNumOfChars = currNum;
            }

            if(c.equals('k')){ // "croak" is over, reduce by one frog
                for(Character ch : map.keySet()){
                    map.put(ch, map.get(ch) - 1);
                }
                currNumberOfFrogs--;
            }


        }
        return minNumberOfFrogs;
    }
}