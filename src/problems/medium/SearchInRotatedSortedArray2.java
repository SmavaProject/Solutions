package problems.medium;

public class SearchInRotatedSortedArray2 {
    /**
     * #81. Search in Rotated Sorted Array II
     * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
     * Solution:
     * https://www.educative.io/courses/grokking-the-coding-interview/RMPVM2Y4PW0
     */

    public boolean search(int[] nums, int target) {
        if(nums.length==0){
            return false;
        }
        int start = 0;
        int end = nums.length-1;
        while(start<=end){

            //avoid duplicates
            while(start<end && nums[start] == nums[start+1]){
                start++;
            }
            while(start < end && nums[end] == nums[end-1] ){
                end--;
            }

            int midd = (start+end)/2;
            if(target == nums[midd]) return true;

            if(nums[start]<nums[midd]){//first part is sorted
                if(target>=nums[start] && target<nums[midd]){// target inside of this first sorted part
                    end = midd -1;
                }else{//tarted is insede of the other part
                    start = midd;
                }
            }else{//second part is sorted
                // we need (midd+1<= end) to avoid null pointer exception
                if((midd+1<= end) && target>=nums[midd+1] && target <= nums[end]){// target inside of this second sorted part
                    start = midd + 1;
                }else{ //target is inside of the other part
                    end = midd -1;
                }
            }
        }
        return false;
    }
}
