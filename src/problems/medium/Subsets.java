package problems.medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    /***
     * #78. Subsets - MEDIUM
     * https://leetcode.com/problems/subsets/
     * Solution with no backtracking needed:
     * https://www.educative.io/courses/grokking-the-coding-interview/gx2OqlvEnWG
     *
     */

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>(); //<<---
        if(nums==null || nums.length== 0){
            return result;
        }
        result.add(new ArrayList<Integer>());

        /*
        Пройди по всем елементам из nums и добавть этот элемент к существующим массивам
        чтоббы получилась новая комбинация
         */
        for (int i = 0; i< nums.length; i++){
            int resSize = result.size(); //number of elements currently saved in the result
            int currNum = nums[i];

            for(int s = 0; s< resSize; s++){
                List<Integer> currArray = result.get(s);
                List<Integer> currArrayCopy = new ArrayList<>(currArray);
                currArrayCopy.add(currNum);
                result.add(currArrayCopy);
            }
        }
        return result;
    }
    /***
     * Notes:
     * 1) List<List<Integer>> result = new ArrayList<List<Integer>>(); //<<--- https://stackoverflow.com/questions/24796273/incompatible-types-list-of-list-and-arraylist-of-arraylist
     * 2) Copy List: List<Integer> currArrayCopy = new ArrayList<>(currArray);
     */
}