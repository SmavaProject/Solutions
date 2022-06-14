package problems.easy;

public class SearchInsertPosition {
    /***
     * #35. Search Insert Position
     * https://leetcode.com/problems/search-insert-position/
     */

    public int searchInsert(int[] nums, int target) {
        int min = 0;
        int max = nums.length-1;
        int midd;
        while(min<=max){
            midd = min + (max-min)/2;
            if(nums[midd] == target)return midd;

            if(target < nums[midd]){
                max = midd -1;
            }else{
                min = midd + 1;
            }
        }

        return min;
    }
}
