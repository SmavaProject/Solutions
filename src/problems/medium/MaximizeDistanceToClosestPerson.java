package problems.medium;

public class MaximizeDistanceToClosestPerson {
    /**
     * #849. Maximize Distance to Closest Person
     * https://leetcode.com/problems/maximize-distance-to-closest-person/
     */

    public int maxDistToClosest(int[] seats) {

        int maxDist = Integer.MIN_VALUE;
        int index = 0;
        int max = 0;
        while(index<seats.length){
            int seat = seats[index];

            //first seat is not taken, take it
            if(index == 0 && seat==0){
                while(seats[index]!=1 && index<seats.length){
                    index++;
                    max++;
                }
                maxDist = Math.max(max, maxDist);
                continue;
            }
            //last seat is not taken, take it
            if(index == seats.length-1 && seat == 0){
                maxDist = Math.max(max, maxDist);
                break;
            }

            //general case
            if(seat == 0){
                max++;
            }else{
                maxDist = Math.max(max/2, maxDist);
                max=1;
            }
            index++;

        }
        return maxDist;
    }
}
