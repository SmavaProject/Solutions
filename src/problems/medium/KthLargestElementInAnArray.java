package problems.medium;

import java.util.PriorityQueue;

/***
 * #215 MEDIUM, Heap
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestElementInAnArray
{
    /***
     * Both solutions work, the second one uses less space and is the other way around - with min heap
     */

    public int findKthLargest_1(int[] nums, int k) {

        PriorityQueue<Integer> heap = new PriorityQueue<>((Integer a, Integer b)-> b.compareTo(a)); //max heap

        for (int i: nums){
            heap.add(i);
        }

        int result = 0;
        while(!heap.isEmpty() && k>0){
            result = heap.poll();
            k--;
        }
        return result;

    }

    public int findKthLargest_2(int[] nums, int k) {

        PriorityQueue<Integer> heap = new PriorityQueue<>((Integer a, Integer b)-> a.compareTo(b)); //min heap

        for (int i: nums){
            heap.add(i);
            if(heap.size()>k){
                heap.poll();
            }
        }

        return heap.poll();

    }
}
