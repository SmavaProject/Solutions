package problems.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class DeleteAndEarn {
    /***
     * #740. Delete and Earn - MEDIUM
     * Dynamic programming
     * Similar to 198. House Robber
     * https://leetcode.com/problems/delete-and-earn/
     * Solution:
     * https://www.youtube.com/watch?v=7FCemBxvGw0
     */

    public int deleteAndEarn(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        /*
        Some numbers in nums may accur several times. Therefore we count the product of all of them
        And we will pick up all of them while iterating
         */
        //Integer, its product
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        for (int i : nums){
            Integer prod = numsMap.getOrDefault(i, 0);
            numsMap.put(i, prod +i);
        }


        ArrayList<Integer> uniqueNums = new ArrayList(numsMap.keySet());
        Collections.sort(uniqueNums); //sort all numbers in ascending order
        //array to collect maximum possible earning so far
        int[] maxEarn = new int[uniqueNums.size()];

        //[2, 3, 5, 6]
        maxEarn[0] = numsMap.get(uniqueNums.get(0)); // max earn for the firs element is always this number itself

        int sum1 = 0;//max earn for the second element depends on the previous number
        int zeroElemSum = numsMap.get(uniqueNums.get(0));
        int oneElemSum = numsMap.get(uniqueNums.get(1));
        if(uniqueNums.get(1) -1 == uniqueNums.get(0)){//we cannot take prev and curr
            sum1 = Math.max(zeroElemSum, oneElemSum);
        }else{//we can take both prev and curr
            sum1 = zeroElemSum +oneElemSum;
        }
        maxEarn[1] = sum1;

        for(int index = 2; index< uniqueNums.size();index++) {

            int currNum = uniqueNums.get(index);
            int currSum = numsMap.get(currNum);
            int prevNum = uniqueNums.get(index-1);

            if( prevNum ==currNum -1){ //we cannot take prev and curr
                //we must decide whether we take curr+the one before current or previous //// <<<<<---------------------------- (!!!!)
                maxEarn[index] = Math.max(currSum + maxEarn[index-2], maxEarn[index-1]);
            }else{//we can take both prev and curr
                maxEarn[index] = currSum + maxEarn[index-1];
            }
        }
        return maxEarn[maxEarn.length -1];
    }
}
