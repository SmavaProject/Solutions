package problems2.medium;

public class TopKFrequentElements {
    //https://leetcode.com/problems/top-k-frequent-elements/


    public int[] topKFrequent(int[] nums, int k) {
        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();
        //min heap out of the box compares VALUES of the map (e.g. frequency of elements
        // because of the comparator: Integer.compare(map.get(a), map.get(b))
        java.util.PriorityQueue<Integer> minHeap = new java.util.PriorityQueue<>((a, b) ->
            Integer.compare(map.get(a), map.get(b)));
        for (int i: nums){
            if (map.containsKey(i)){
                map.put(i, map.get(i) + 1);
            }else{
                map.put(i, 1);
            }
        }
        for (Integer key : map.keySet()){
            minHeap.offer(key);
            if(minHeap.size()>k){ //<< always maintain no more than k elements, remove not frequent ones
                minHeap.poll();
            }
        }
        int[] result = new int[k];
        for (int i = 0; i< result.length; i++){
            result[i] = minHeap.poll();
        }
        return result;
    }

}
