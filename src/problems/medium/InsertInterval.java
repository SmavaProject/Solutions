package problems.medium;

import java.util.ArrayList;

public class InsertInterval {
    /**
     * 57. Insert Interval - MEDIUM
     * https://leetcode.com/problems/insert-interval/
     *
     * Solution:
     * https://www.educative.io/courses/grokking-the-coding-interview/3jKlyNMJPEM
     */

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length==0){
            int[][] res = new int[1][2];
            res[0] = newInterval;
            return res;
        }
        ArrayList<int[]> result = new ArrayList<>();
        int current = 0;

        //Step 1:
        //intervals dont overlap and current is smaller than newInterval
        //just add the interval to the array
        while (current < intervals.length && intervals[current][1]<newInterval[0]){
            int[] currInterval = intervals[current];
            result.add(currInterval);
            current++;

        }
        //Step 2:
        //intervals overlap, lets find the end point for a new interval
        // continue doing so till they stop overlapping
        while (current < intervals.length && newInterval[1] >= intervals[current][0]){
            int[] currInterval = intervals[current];
            newInterval[0] = Math.min(currInterval[0], newInterval[0]);
            newInterval[1] = Math.max(currInterval[1], newInterval[1]);
            current++;
        }
        result.add(newInterval);

        //Step 3:
        //just add the rest intervals to the result
        while(current < intervals.length){
            result.add(intervals[current]);
            current++;
        }

        return result.toArray(new int[result.size()][2]);
    }

    /***
     * Notes:
     * 1) Dont do Step1 and Step2 in one while loop. It will be a mess otherwise!!!
     * 2) Convert list to array: list.toArray(new int[list.size()][2])
     */
}
