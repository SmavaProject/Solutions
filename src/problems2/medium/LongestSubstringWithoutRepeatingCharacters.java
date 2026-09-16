package problems2.medium;

public class LongestSubstringWithoutRepeatingCharacters {

    //https://leetcode.com/problems/longest-substring-without-repeating-characters/?envType=problem-list-v2
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.length() == 1){
            return s.length();
        }

        java.util.Set<Character> set = new java.util.HashSet();
        int currLen = 0;
        int maxLen = 0;
        int pointer1 = 0;
        int pointer2 = 0;

        while (pointer2 < s.length()){
            Character currCh = s.charAt(pointer2);
            if (!set.contains(currCh)){
                set.add(currCh);
                currLen = set.size();
                maxLen = Math.max(maxLen, currLen);
                pointer2++;
            }else{
                Character firstChar = s.charAt(pointer1);
                set.remove(firstChar);
                pointer1++;
            }

        }

        return maxLen;
    }

}
