package problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3 {
    /***
     * # 15. 3Sum
     * https://leetcode.com/problems/3sum/
     * Triplet Sum to Zero (medium):
     * https://www.educative.io/courses/grokking-the-coding-interview/gxk639mrr5r
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>  result = new ArrayList<>();
        if(nums.length<3){
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i< nums.length; i++){
            if(i==0 || nums[i]!=nums[i-1]){ // <--- avoid duplicates!
                searchPairs(nums, -nums[i], i+1, result);
            }
        }

        return result;
    }

    public void searchPairs(int[] nums, int targetSum, int leftPointer, List<List<Integer>> result){
        int rightPointer = nums.length-1;
        while(leftPointer<rightPointer){
            if(nums[leftPointer] + nums[rightPointer] == targetSum){
                result.add(Arrays.asList(-targetSum, nums[leftPointer], nums[rightPointer]));

                rightPointer--;
                leftPointer++;

                while(rightPointer>leftPointer && nums[rightPointer]==nums[rightPointer+1]){ // <--- avoid duplicates!
                    rightPointer--;
                }
                while(leftPointer<rightPointer && nums[leftPointer]==nums[leftPointer-1]){ // <--- avoid duplicates!
                    leftPointer++;
                }

            }else if(nums[leftPointer] + nums[rightPointer] > targetSum){
                rightPointer--;
            }else{
                leftPointer++;
            }
        }
    }

    /***
     * Notes:
     * 1) add new list with many elements to the List<List<Integer>>:
     * list.add(Arrays.asList(el1, el2, el3));
     */
}
