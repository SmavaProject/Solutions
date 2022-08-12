package problems.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class ReorganizeString {
    /***
     * #767. Reorganize String
     * https://leetcode.com/problems/reorganize-string/
     */
    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            int i = map.getOrDefault(c, 0);

            if(i +1 > (s.length() +1)/2){
                return "";
            }

            map.put(c, i+1);
        }

        // max heap
        PriorityQueue<Character> q = new PriorityQueue<>(new Comparator<Character>(){
            public int compare( Character a, Character b){
                if(map.get(a) > map.get(b)){
                    return -1;
                }else if(map.get(a) < map.get(b)){
                    return 1;
                }else{
                    return a.compareTo(b) ;
                }
            }
        });

        for (Character c: map.keySet()){
            q.add(c);
        }

        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()){
            Character curr = q.poll();
            if(sb.length() == 0 || sb.charAt(sb.length()-1)!= curr){
                sb.append(curr);
                if(map.get(curr)!=1){
                    map.put( curr, map.get(curr) -1);
                    q.add(curr);
                }else{
                    map.remove(curr);
                }
            }else{
                if(!q.isEmpty()){
                    Character prev = q.poll();
                    sb.append(prev);
                    if(map.get(prev)!=1){
                        map.put( prev, map.get(prev) -1);
                        q.add(prev);
                    }
                    q.add(curr);
                }

            }


        }
        return sb.toString();
    }

}
