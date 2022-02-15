package problems.medium;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray2 {
    /***
     * #215 Kth Largest Element in an Array-  MEDIUM
     * https://leetcode.com/problems/kth-largest-element-in-an-array/
     * Solution:
     * Top 'K' Numbers (easy):
     * https://www.educative.io/courses/grokking-the-coding-interview/RM535yM9DW0
     */


    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i< nums.length; i++){
            if(i<k){
                minHeap.add(nums[i]);
            }else{
                //heap already contains k-th largest element, we dont need to add 'small' numbers there
                //because they will not be Kth largest element
                if(nums[i]>minHeap.peek()){
                    minHeap.poll();
                    minHeap.add(nums[i]);

                }
            }

        }
        return minHeap.poll();
    }
}
