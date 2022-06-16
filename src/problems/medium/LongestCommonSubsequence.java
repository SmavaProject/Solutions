package problems.medium;

import java.util.HashMap;

public class LongestCommonSubsequence {
    /***
     * #1143. Longest Common Subsequence
     * https://leetcode.com/problems/longest-common-subsequence/
     * https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/B8Pq4ZnBN0N
     */
    public int longestCommonSubsequence(String text1, String text2) {
        HashMap<String, Integer> map = new HashMap<>();
        int maxLen = 0;
        recursion(map, 0, 0, text1, text2);

        for(String key: map.keySet()){
            maxLen = Math.max(maxLen, map.get(key));
        }
        return maxLen;
    }

    public int recursion(HashMap<String, Integer> map, int index1, int index2, String text1, String text2){
        if(index1 == text1.length() || index2 == text2.length()){
            return 0;
        }
        String key = String.valueOf(index1) + "-" + String.valueOf(index2);
        if(!map.containsKey(key)){
            if(text1.charAt(index1) == text2.charAt(index2)){
                int max = recursion(map, index1+1, index2+1, text1, text2) + 1;
                map.put(key, max);

            }else{
                int maxLen = Math.max(recursion(map, index1, index2+1, text1, text2),
                        recursion(map, index1+1, index2, text1, text2));
                map.put(key, maxLen);
            }
        }
        return map.get(key);
    }


}
