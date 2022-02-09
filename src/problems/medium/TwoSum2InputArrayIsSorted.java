package problems.medium;

public class TwoSum2InputArrayIsSorted {
    /***
     *  #167. Two Sum II - Input Array Is Sorted - MEDIUM
     *  https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
     *  https://www.educative.io/courses/grokking-the-coding-interview/xog6q15W9GP
     *
     */

    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length == 0){
            return new int[0];
        }
        int start = 0;
        int end = numbers.length-1;
        int[] result = new int[2];


        while(start<end){
            int currStart = numbers[start];
            int currEnd = numbers[end];
            int currSum = currStart + currEnd;
            if(currSum == target){
                result[0] = start + 1;
                result[1] = end + 1;
                return result;
            }else if (currSum > target){
                end--;
            }else if (currSum < target){
                start++;
            }

        }

        return result;


    }
}
