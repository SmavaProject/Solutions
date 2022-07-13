package problems.easy;

import java.util.PriorityQueue;

public class LastStoneWeight {
    /**
     * #1046. Last Stone Weight
     * https://leetcode.com/problems/last-stone-weight/
     */
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i1, i2) -> i2 - i1);
        for(int i : stones){
            maxHeap.add(i);
        }

        while(!maxHeap.isEmpty()){
            int y = maxHeap.poll();
            if(maxHeap.isEmpty()) return y;
            int x = maxHeap.poll();

            if(x == y) continue;

            int diff = y - x;
            maxHeap.add(diff);
        }
        return  0;
    }
}