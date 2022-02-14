package problems.easy;

public class BinarySearch {
    /***
     * #704. Binary Search - EASY
     * https://leetcode.com/problems/binary-search/
     *
     */
    public int search(int[] nums, int target) {


        return binarySearch(nums, 0, nums.length-1, target);

    }
    public int binarySearch(int[] nums,int start, int end, int target){
        if(start>end){
            return -1;
        }
        int middle = start + (end - start)/2; //<---- start +
        if(target== nums[middle]){
            return middle;
        }
        if(target>=nums[start] && target <=nums[middle]){ //<---- >= && <=
            return binarySearch(nums, start, middle, target);
        }else{
            return binarySearch(nums, middle+1, end, target);
        }
    }
}
