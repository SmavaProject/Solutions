package problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class GroupAnagrams {
    /**
     * #49. Group Anagrams
     * https://leetcode.com/problems/group-anagrams/
     * Чтобы не траверсить все key в HashMap и не проверять каждый ли Anagram для текущей string,
     * Нужно сделать чтобы sortedKey из всех букв было ключом к группе Anagram
     */

    public List<List<String>> groupAnagrams(String[] strs) {

        ConcurrentHashMap<String, ArrayList<String>> map = new ConcurrentHashMap<>(); // <<<----- !!!

        for(int i = 0; i< strs.length; i++){
            String str = strs[i];

            char[] ch = str.toCharArray();
            Arrays.sort(ch);

            String sortedKey = new String(ch); // <<<-------

            if(map.containsKey(sortedKey)){
                ArrayList<String> anagrams = map.get(sortedKey);
                anagrams.add(str);
                map.put(sortedKey, anagrams);
            }else{
                ArrayList<String> anagrams = new ArrayList<>();
                anagrams.add(str);
                map.put(sortedKey, anagrams);
            }

        }

        ArrayList<List<String>> result = new ArrayList<>();
        result.addAll(map.values());
        return result;
    }

    private boolean isAnagram(String str, String s){
        if(str.length()!=s.length()) return false;
        HashMap<Character, Integer> chars = new HashMap<>();

        for(int i = 0; i< str.length(); i++){
            Character c = str.charAt(i);
            Integer count = chars.getOrDefault(c, 0);
            chars.put(c, count+1);
        }

        for(int i = 0; i< s.length(); i++){
            if(chars.containsKey(s.charAt(i))){
                Integer count = chars.get(s.charAt(i));
                count--;
                if(count == 0){
                    chars.remove(s.charAt(i));
                }else{
                    chars.put(s.charAt(i), count);
                }
            }
        }

        return chars.isEmpty();

    }
}
