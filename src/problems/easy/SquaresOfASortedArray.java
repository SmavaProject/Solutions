package problems.easy;

public class SquaresOfASortedArray {

    /**
     * #977. Squares of a Sorted Array - EASY
     * https://leetcode.com/problems/squares-of-a-sorted-array/
     * two pointers:
     * https://www.educative.io/courses/grokking-the-coding-interview/R1ppNG3nV9R
     *
     */

    public int[] sortedSquares(int[] nums) {
        if(nums.length==0){
            return new int[0];
        }
        int start = 0;
        int end = nums.length-1;
        int[] result = new int[nums.length];
        int index = result.length-1;

        while(index>=0){
            int startSq = nums[start] * nums[start];
            int endSq = nums[end] * nums[end];
            if(startSq>=endSq){
                result[index] = startSq;
                index--;
                start++;
            }else{
                result[index] = endSq;
                index--;
                end--;
            }
        }
        return result;
    }
}
