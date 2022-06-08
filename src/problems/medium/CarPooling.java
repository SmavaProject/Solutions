package problems.medium;

public class CarPooling {
    /***
     * #1094. Car Pooling
     * https://leetcode.com/problems/car-pooling/
     */
    public boolean carPooling(int[][] trips, int capacity) {
        int[] fromTo = new int[1001]; // NOTE: we can use HashMap if the length of fromTo is unknown
        for(int j = 0; j< trips.length; j++){
            int[] trip = trips[j];
            for(int i = trip[1]; i< trip[2]; i++){
                fromTo[i]+=trip[0];
                if(fromTo[i]>capacity){
                    return false;
                }
            }
        }

        return true;
    }
}
