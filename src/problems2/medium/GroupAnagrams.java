package problems2.medium;

public class GroupAnagrams {
    //https://leetcode.com/problems/group-anagrams/description/

    public java.util.List<java.util.List<String>> groupAnagrams(String[] strs) {
        java.util.HashMap<String, java.util.ArrayList<String>> map = new java.util.HashMap();
        for (String s: strs){

            char[] chars = s.toCharArray();
            java.util.Arrays.sort(chars);
            String sortedS = new String(chars);

            if (!map.containsKey(sortedS)){
                java.util.ArrayList<String> list =new java.util.ArrayList<>();
                list.add(s);
                map.put(sortedS, list);
            }else{
                java.util.ArrayList<String> list = map.get(sortedS);
                list.add(s);
                map.put(sortedS, list);
            }
        }

        return new java.util.ArrayList(map.values());
    }

}
