package problems.medium;

import java.util.Arrays;

public class BoatsToSavePeople {
    /***
     * #881. Boats to Save People
     * https://leetcode.com/problems/boats-to-save-people/
     */
    public int numRescueBoats(int[] people, int limit) {
        int numOfBoats = 0;

        Arrays.sort(people);
        int start = people.length-1;
        int end = 0;

        while(start >= end){
            int currLoad = people[start--];
            if((start >= 0) &&currLoad + people[start] <= limit){
                start--;
            }else if(currLoad + people[end] <= limit){
                end++;
            }
            numOfBoats++;
        }


        return numOfBoats;
    }
}
