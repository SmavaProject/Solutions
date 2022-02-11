package problems.easy;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {

    /**
     * #448. Find All Numbers Disappeared in an Array
     * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
     * Pattern: Cyclic Sort
     * https://www.educative.io/courses/grokking-the-coding-interview/Y52qNM0ljWK
     */

    public List<Integer> findDisappearedNumbers(int[] nums) {

        int i = 0;
        List<Integer> result = new ArrayList<>();

        /*
        Поскольку в массиве есть недостающе элементы и повторные, мы остаемся на одном месте nums[i]
        до тех пор пока не переместим каждый элемент оказавщийся на том месте на свое место
         */
        while (i< nums.length){
            int currInt = nums[i];
            int intOnPlaceOfCurrInt = nums[nums[i] - 1];
            if (currInt != intOnPlaceOfCurrInt){
                swap(nums, i ,nums[i]-1);
            }else{
                i++;
            }

        }

        for (int j = 0; j< nums.length; j++){
            if(nums[j]!=j+1){
                result.add(j+1); // <----- !!!
            }
        }
        return result;
    }

    public void swap(int[] nums, int currentPlace, int rightPlace){
        int tmp = nums[rightPlace];
        nums[rightPlace] = nums[currentPlace];
        nums[currentPlace] = tmp;
    }

}
