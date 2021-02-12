package problems.medium;

import java.util.HashSet;
import java.util.Set;

/***
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/ #3 MEDIUM
 */
public class LongestSubstringWithoutRepeatingCharacters
{
    /***
     * Slidig window / two pointers
     */
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<1){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        int start = 0;
        int end = 0;
        int maxLength = 0;
        int currLength = 0;

        Set<Character> set = new HashSet<>();

        //обязательно while, потому что нужно двигать отдельно start и end
        //обязательно внутри while что-то одно должно передвинуться: или start или end
        while(end<s.length()){
            Character endChar = s.charAt(end);
            if(!set.contains(endChar)){
                set.add(endChar);
                currLength = set.size();
                maxLength = Math.max(maxLength, currLength);
                end++;
            }else{
                Character startChar = s.charAt(start);
                set.remove(startChar);
                start++;
            }
        }
        return maxLength;

    }
}
