package problems.medium;

public class SearchInRotatedSortedArray {
    /***
     * #33. Search in Rotated Sorted Array - Medium
     * https://leetcode.com/problems/search-in-rotated-sorted-array/
     * Solution:
     * https://www.educative.io/courses/grokking-the-coding-interview/RMPVM2Y4PW0
     */

    /***
     * 1) Нужно разделить массив на 2 части (до midd и после) и понять какая из них отсортирована
     *   сравнив nums[start], nums[midd] и nums[end]
     * 2) Если target находится внутри отсортированной части - продолжаем искать его там
     * 3) Если нет, то target в неотсортированной части
     */
    public int search(int[] nums, int target) {
        if(nums.length==0){
            return -1;
        }
        int start = 0;
        int end = nums.length-1;
        int midd = -1;
        while(start<=end){
            midd = start+ (end-start)/2;
            int nStart = nums[start];
            int nMidd = nums[midd];
            int nEnd = nums[end];

            if(nMidd==target){ //<-------- !!!
                return midd;
            }
            //отсортирована первая часть массива
            if(nStart<=nMidd){
                if(target>=nStart&&target<=nMidd){
                    end = midd;
                }else{
                    start = midd+1;
                }
            }else{//отсортирована вторая часть массива
                if(target>nMidd&&target<=nEnd){
                    start = midd+1;
                }else{
                    end = midd;
                }
            }
        }
        return -1;
    }
}
