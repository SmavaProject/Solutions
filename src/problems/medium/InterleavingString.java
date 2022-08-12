package problems.medium;

import java.util.HashMap;
import java.util.Map;

public class InterleavingString {
    /**
     * #97. Interleaving String
     * https://leetcode.com/problems/interleaving-string/
     * Similar to: 1143. Longest Common Subsequence
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != (s1.length() + s2.length())) return false;
        Map<String, Boolean> map = new HashMap<>();
        return recursion(map, s1, s2, s3, 0, 0, 0);
    }

    private boolean recursion(Map<String, Boolean> map, String s1, String s2, String s3, int i1, int i2, int i3){
        if(i1 == s1.length() && i2 == s2.length() && i3 == s3.length()){
            return true;
        }

        Character c3 = s3.charAt(i3);
        boolean opt1 = false;
        boolean opt2 = false;

        String key = i1 + "-" + i2 + "-" + i3;
        if(!map.containsKey(key)){

            if(i1 < s1.length() && s1.charAt(i1) == c3){
                opt1 = recursion(map, s1, s2, s3, i1 +1, i2, i3 +1);
            }
            if(i2 < s2.length() && s2.charAt(i2) ==c3 ){
                opt2 = recursion(map, s1, s2, s3, i1, i2+1, i3 +1);
            }
            map.put(key, opt1 || opt2);
        }

        return map.get(key);

    }
}
