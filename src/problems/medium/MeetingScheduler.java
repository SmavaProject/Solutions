package problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeetingScheduler {
    /***
     * 1229. Meeting Scheduler
     * https://leetcode.com/problems/meeting-scheduler/
     */
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        int index1 = 0;
        int index2 = 0;

        ArrayList<Integer> result = new ArrayList<Integer>();

        //sort by first value - by start time
        Arrays.sort(slots1, (a, b) -> a[0] - b[0]);
        Arrays.sort(slots2, (a, b) -> a[0] - b[0]);

        while(index1<slots1.length && index2<slots2.length){
            int[] slot1 = slots1[index1];
            int[] slot2 = slots2[index2];
            if(overlappingInt(slot1, slot2)>=duration){
                int start = Math.max(slot1[0], slot2[0]);
                int end = start + duration;
                result.add(start);
                result.add(end);
                return result;
            }else{
                //move to the next available slot
                //keep the slot which finishes later
                if(slot1[1]<slot2[1]){
                    index1++;
                }else{
                    index2++;
                }
            }
        }

        return result;
    }

    private int overlappingInt(int[] slot1, int[] slot2){
        int start = Math.max(slot1[0], slot2[0]); //<<----------  !!!!
        int end = Math.min(slot1[1], slot2[1]);

        if(end<start)return 0;
        return end - start;

    }
}