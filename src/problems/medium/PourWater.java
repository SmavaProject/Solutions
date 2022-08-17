package problems.medium;

public class PourWater {
    /***
     * #755. Pour Water
     * https://leetcode.com/problems/pour-water/
     */
    public int[] pourWater(int[] heights, int volume, int k) {
        if(heights.length == 0 || volume == 0) return heights;
        int index = k;
        while(volume > 0){
            index = k; //<<<---------- always start with k
            for(int i = index -1; i>=0 && volume>0; i--){//find the local low (to the left from k)
                if(heights[i]>heights[index])break;//if at some point we find spike - break

                if(heights[i]<heights[index]){// continue searching for a low point by reassigning index to i
                    index = i;
                }
            }

            if(index !=k){
                heights[index]++;
                volume--;
                continue;
            }
            for(int i = index +1; i<heights.length && volume>0; i++){ //find the local low
                if(heights[i]>heights[index])break;

                if(heights[i]<heights[index]){
                    index = i;
                }
            }

            if(volume>0){
                heights[index]++;
                volume--;
            }
        }

        return heights;
    }
}
