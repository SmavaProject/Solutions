package problems.medium;

public class FindFirstAndLastPositionOfElementInSortedArray {
    /***
     * #34. Find First and Last Position of Element in Sorted Array - MEDIUM
     * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
     *
     */

    public int[] searchRange(int[] nums, int target) {

        int[] result = new int[]{-1, -1};
        int start = 0;
        int end = nums.length-1;

        if(nums.length == 0){
            return result;
        }

        while(start<=end){ // <--- (<= not <)
            int midd = start + (end-start)/2;
            if(target<nums[midd]){
                end = midd-1;
            }else if(target>nums[midd]){
                start = midd+1;
            }else{
                //target is found
                int l = midd;
                int r = midd;
                while(l>=0 && nums[l]==target){ //two conditions inside while, not while(l>0=){if(nums[l]==target)}
                    l--;
                }
                while(r<=nums.length-1 && nums[r]==target){
                    r++;
                }
                result[0] = l+1;
                result[1] = r-1;
                break;
            }
        }

        return result;
    }

}
