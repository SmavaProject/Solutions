package problems.medium;

import java.util.TreeMap;

public class DesignHitCounter {
    /***
     * #362. Design Hit Counter
     * https://leetcode.com/problems/design-hit-counter/
     */

    //Slow solution, because we look O(nLogn) every time se search for key in getHits
    //but it works for all possible orders of adding and getting timestamps
    class HitCounter {

        TreeMap<Integer, Integer> treeMap;
        public HitCounter() {
            treeMap = new TreeMap<>();
        }

        public void hit(int timestamp) {
            //TreeMap<Integer, Integer> treeMap1 = treeMap; //for debugging
            if(!treeMap.containsKey(timestamp)){
                treeMap.put(timestamp, 1);
            }else{
                treeMap.put(timestamp, treeMap.get(timestamp) + 1);
            }
        }

        public int getHits(int timestamp) {
            //TreeMap<Integer, Integer> treeMap1 = treeMap; //for debugging
            Integer key = treeMap.floorKey(timestamp);
            int numberOfHits = 0;
            while(key != null && key > timestamp - 300){
                Integer value = treeMap.get(key);
                numberOfHits += value;
                key--;
                key = treeMap.floorKey(key);
            }
            return numberOfHits;
        }
    }
}
