package problems.medium;

public class SortColors {
    /***
     * #75. Sort Colors
     * https://leetcode.com/problems/sort-colors/
     */
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int curr = 0;

        while(curr<nums.length && curr<= right){
            int cNum = nums[curr];
            if(cNum == 0){
                int tmp = nums[left];
                nums[left] = cNum;
                nums[curr] = tmp;
                left++;
                curr++;
            }else if(cNum == 2){
                int tmp = nums[right];
                nums[right] = cNum;
                nums[curr] = tmp;
                right--;
            }else{
                curr++;
            }
        }
    }
}
