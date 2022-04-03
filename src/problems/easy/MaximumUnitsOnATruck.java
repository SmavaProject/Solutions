package problems.easy;

import java.util.PriorityQueue;

public class MaximumUnitsOnATruck {
    /**
     * #1710. Maximum Units on a Truck - Easy
     * GREEDY
     * https://leetcode.com/problems/maximum-units-on-a-truck/
     */
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int maxUnits = 0;
        //orginaze all box so that the boxes with most units are on the top
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a1, a2) -> a2[1]-a1[1]);
        for (int[] box: boxTypes){
            maxHeap.add(box);
        }
        while(!maxHeap.isEmpty()){
            int[] currentBoxType = maxHeap.poll(); // take the box with the most units

            int numberOfBoxes = currentBoxType[0];
            int numberOfBoxesToTake;
            if(numberOfBoxes<truckSize){
                numberOfBoxesToTake = numberOfBoxes;
            }else{
                numberOfBoxesToTake = truckSize;
            }
            maxUnits+= currentBoxType[1] * numberOfBoxesToTake;
            truckSize-= numberOfBoxesToTake;
            if(truckSize==0)break;
        }
        return maxUnits;
    }
}
