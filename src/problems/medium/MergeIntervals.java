package problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {
    /***
     * #56. Merge Intervals - MEDIUM
     * https://leetcode.com/problems/merge-intervals/
     * https://www.educative.io/courses/grokking-the-coding-interview/3jyVPKRA8yx
     */

    public int[][] merge(int[][] intervals) {

        Comparator<int[]> firstElementComp = new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return Integer.compare(a[0], b[0]);
            }
        };

        Arrays.sort(intervals, firstElementComp);
        int[] prevArray = intervals[0];

        ArrayList<int[]> result = new ArrayList<>();

        for (int i = 1; i< intervals.length; i++){
            int[] currentArray = intervals[i];
            //arrays dont overlap
            if(prevArray[1] < currentArray[0]){
                result.add(prevArray);
                prevArray = currentArray;
                //arrays overlap
            }else{
                int[] mergedArray = new int[]{prevArray[0], Math.max(prevArray[1], currentArray[1])};
                prevArray =  mergedArray;
            }

        }

        result.add(prevArray);

        //transfer all intervals to the array
        int[][] merged = new int[result.size()][2];
        for (int i = 0; i<result.size(); i++){
            int[] curr = result.get(i);
            merged[i] = curr;
        }


        return merged;
    }
}
