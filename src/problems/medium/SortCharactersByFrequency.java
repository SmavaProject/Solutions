package problems.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {

    /***
     * #451. Sort Characters By Frequency - MEDIUM
     * https://leetcode.com/problems/sort-characters-by-frequency/
     *
     * https://www.educative.io/courses/grokking-the-coding-interview/gxZz615BPPG
     *
     */

    public String frequencySort(String s) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (Character c: s.toCharArray()){
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0)+1);
        }
        //elements are sorted in descending order (by frequncy)
        //maxHeap: [e=2, t=1, r=1]
        PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>((c1, c2) -> c2.getValue() - c1.getValue());

        maxHeap.addAll(frequencyMap.entrySet());

        StringBuilder sb = new StringBuilder();

        while(!maxHeap.isEmpty()){
            Map.Entry<Character, Integer> ent = maxHeap.poll();
            for(int i = 0; i< ent.getValue(); i++){
                sb.append(ent.getKey());
            }
        }
        return sb.toString();

    }

    /**
     * Notes:
     * 1) iterate over string: s.toCharArray()
     * 2) access map element: Map.Entry<Character,Integer>
     * 3) add an entire collection to the heap: maxHeap.addAll(...)
     */
}
