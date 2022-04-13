package problems.medium;

public class SortTransformedArray {
    /**
     * #360. Sort Transformed Array - MEDIUM
     * https://leetcode.com/problems/sort-transformed-array/
     * Similar to #977. Squares of a Sorted Array
     * but with one important diff: graph of parabola can be open Upward or Downward
     * depending on the value of a in ax2 + b2x + c;
     */
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] numsResult = new int[nums.length];
        int start = 0;
        int end = nums.length-1;
        int index = a >=0 ? nums.length-1 : 0; //<<-----------------
        while(start<=end){
            int startInt = calcPorabola(a,  b, c, nums[start]);
            int endInt = calcPorabola(a,  b, c, nums[end]);
            if(a>=0){ // we start from the end of numsResult
                if(startInt>endInt){
                    numsResult[index]=startInt;
                    start++;
                }else{
                    numsResult[index]=endInt;
                    end--;
                }
                index--;
            }else{//we start from tbe beginnign of the numsResult
                if(startInt<endInt){
                    numsResult[index]=startInt;
                    start++;
                }else{
                    numsResult[index]=endInt;
                    end--;
                }
                index++;
            }

        }
        return numsResult;
    }
    public int calcPorabola(int a, int b, int c, int x){
        return a*x*x + b*x + c;
    }
}