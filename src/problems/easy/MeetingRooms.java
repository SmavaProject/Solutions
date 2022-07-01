package problems.easy;

import java.util.Arrays;

public class MeetingRooms {
    /**
     * 252. Meeting Rooms
     * https://leetcode.com/problems/meeting-rooms/
     */

        public boolean canAttendMeetings(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
            for(int i = 1; i< intervals.length; i++){
                int[] prev = intervals[i-1];
                int[] curr = intervals[i];
                if(prev[1]>curr[0])return false;
            }

            return true;
        }
}
