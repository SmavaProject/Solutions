package problems.medium;

import java.util.HashMap;

public class LongestSubstringWithAtMostKDistinctCharacters {
    /**
     * #340. Longest Substring with At Most K Distinct Characters - MEDIUM
     * https://www.educative.io/courses/grokking-the-coding-interview/YQQwQMWLx80
     */

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k==0 || s==null){
            return 0;
        }
        int start = 0;
        int longestSubstr = 0;

        /**
         * Важно!! всегда добавлять новую букву в map, если окажется что она лишняя и размер map больше чем нужно - уберем
         * Не наоборот!! (не добавлять в случае если только размер map позволяет, иначе придется добавлять в мар в двух местах)
         **/

        //calculate frequencies of characters in the current substring
        HashMap<Character, Integer> map = new HashMap<>(k);

        for (int end = 0; end < s.length(); end++){
            int currSubstr = 0;
            char currChar = s.charAt(end);
            map.put(currChar, map.getOrDefault(currChar, 0)+1);

            while(map.size()>k){
                Character startChar = s.charAt(start);
                Integer startCharFrequency = map.get(startChar);
                if(startCharFrequency!=null && startCharFrequency == 1){
                    map.remove(startChar);
                }else{
                    map.put(startChar, startCharFrequency-1);
                }
                start++;
            }


            currSubstr = end - start + 1;
            longestSubstr = Math.max(currSubstr, longestSubstr);
        }

        return longestSubstr;
    }
}
