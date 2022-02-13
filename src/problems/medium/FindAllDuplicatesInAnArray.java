package problems.medium;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {
    /***
     * # 442. Find All Duplicates in an Array - MEDIUM
     * https://leetcode.com/problems/find-all-duplicates-in-an-array/
     * Find all Duplicate Numbers (easy)
     * https://www.educative.io/courses/grokking-the-coding-interview/RLw1Pjk1GQ0
     */

    public List<Integer> findDuplicates(int[] nums) {

        int pointer = 0;
        List<Integer> result = new ArrayList<>();

        while(pointer<nums.length){
            int currInt = nums[pointer];
            int currIntPlace = pointer + 1;
            int rightIntPlace = currInt - 1;
            /*
            (nums[pointer]!=nums[rightIntPlace])
            we need to avoid an infinite loop when duplicate numbers wil be "sorted" with each other
            e.g. 3 on right place and on place 1:
            nums: [3,2,3,4,8,2,7,1]
             */
            if(currInt!=currIntPlace && (nums[pointer]!=nums[rightIntPlace]) ){ //<--
                int tmp = nums[rightIntPlace];
                nums[rightIntPlace] = currInt;
                nums[pointer] = tmp;
            }else{
                pointer++;
            }

        }

        for (int i = 0; i< nums.length; i++){
            if(nums[i]!= i+1){
                result.add(nums[i]);
            }
        }

        return result;
    }

}
