package problems2.easy;

public class ValidAnagram {

    //https://leetcode.com/problems/valid-anagram/

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }

        java.util.HashMap<Character, Integer> map = new java.util.HashMap<>();
        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                int num = map.get(ch) + 1;
                map.put(ch, num);
            } else {
                map.put(ch, 1);
            }
        }

        for (char c: t.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
            }else{
                return false;
            }
        }

        java.util.List<Integer> list = new java.util.LinkedList<>(map.values());
        java.util.Set<Integer> set = new java.util.HashSet<>(list);

        return set.size() == 1 && set.contains(0);
    }

}
