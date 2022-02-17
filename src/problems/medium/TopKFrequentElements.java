package problems.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    /***
     * #347 Top K Frequent Elements - MEDIUM
     * https://leetcode.com/problems/top-k-frequent-elements/
     */

    public int[] topKFrequent(int[] nums, int k) {
        if(k==0){ //??

        }
        //<num, count>
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i  = 0; i< nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        //elements are saved in ascending order: e.g. [-1:1], [2:3], [0:4]
        //<num, count>
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((e1, e2)-> e1.getValue() - e2.getValue());


        for(Map.Entry<Integer, Integer> entry : map.entrySet()){ //<----
            if(minHeap.size()<k){
                minHeap.add(entry);
            }else{
                Integer topCount = minHeap.peek().getValue();
                Integer entryCount = entry.getValue();
                if(entryCount>topCount){
                    minHeap.poll();
                    minHeap.add(entry);
                }
            }
        }
        int[] result = new int[k];
        for(int i = 0; i< result.length; i++){
            result[i] = minHeap.poll().getKey();
        }

        return result;
    }
}
