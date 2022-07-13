package problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FindAllAnagramsInAString {
    /***
     * #438. Find All Anagrams in a String
     * https://leetcode.com/problems/find-all-anagrams-in-a-string/
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(p.length()>s.length()) return result;

        HashMap<Character, Integer> chars = new HashMap<>();
        for(int i = 0; i< p.length(); i++){
            Integer count = chars.getOrDefault(p.charAt(i), 0);
            chars.put(p.charAt(i), count +1);
        }

        int start = 0;
        int end = 0;
        int len = p.length();


        while(end<s.length()){
            while(len>1){ //create first window. Make it 1 char smaller - to continue to line 35 !!!!
                Character c = s.charAt(end);
                if(chars.containsKey(c)){
                    Integer count = chars.get(c);
                    chars.put(c, count-1);
                }
                len--;
                end++;
            }

            //after the initial window is built
            Character curr = s.charAt(end);
            if(chars.containsKey(curr)){
                chars.put(curr, chars.get(curr)-1);

                HashSet<Integer> values = new HashSet(chars.values());
                if(values.size() == 1 && values.contains(Integer.valueOf("0"))){
                    result.add(start);
                }


            }

            Character first = s.charAt(start);
            if(chars.containsKey(first)){
                Integer count = chars.get(first);
                chars.put(first, chars.get(first) + 1);
            }
            start++;
            end++;

        }
        return result;
    }
}