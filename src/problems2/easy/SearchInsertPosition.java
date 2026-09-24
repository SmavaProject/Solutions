package problems2.easy;

public class SearchInsertPosition {
    //https://leetcode.com/problems/search-insert-position/

    public int searchInsert(int[] nums, int target) {
        int min = 0;
        int max = nums.length -1;
        int midd = nums.length/2;
        while (min <= max){
            midd = (min + max)/2;
            int curr = nums[midd];
            if (curr == target){
                return midd;
            }

            if (curr < target){
                min = midd + 1 ; //<<<---
            } else {
                max = midd -1; //<<<---
            }

        }
        return min; //<<< return min, because if current is < target and min==max, midd +1 (updated min) is the insert position
    }

}
