package problems.medium;

public class FindPeakElement {
    /***
     * #162. Find Peak Element - MEDIUM
     * Solution:
     * Bitonic Array Maximum
     * https://www.educative.io/courses/grokking-the-coding-interview/RMyRR6wZoYK
     */

    public int findPeakElement(int[] nums) {
        if(nums.length == 0 || nums.length == 1)
            return 0;

        int start = 0;
        int end = nums.length-1;
        int midd = -1;
        while(start<end){
            midd = start + (end - start) / 2;
            if(nums[midd]>=nums[midd+1]){// [.., 5, 3, ] <-- search in the first part
                end = midd;
            }else{//[1, 5,.., ] <-- search in the second part
                start = midd +1; //<-- midd+1 (!!)
            }
        }
        return start;
    }
}
