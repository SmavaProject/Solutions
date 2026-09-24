package problems2.medium;

public class FindFirstAndLastPositionElementInSortedArray {
    //https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

    public int[] searchRange(int[] nums, int target) {

        int left = searchLeft(nums, target);
        int right = searchRight(nums, target);
        return new int[] {left, right};
    }

    public int searchRight(int[] nums, int target){
        int min = 0;
        int max = nums.length-1;
        int midd = max/2;
        int rightIndex = -1;

        while(min<=max){
            midd = (min + max)/2;
            int curr = nums[midd];

            if(curr<target){
                min = midd +1;
            }else if (curr> target){
                max = midd - 1;
            }else{
                rightIndex = midd;
                min = midd + 1;
            }

        }
        return rightIndex;
    }

    public int searchLeft(int[] nums, int target){
        int min = 0;
        int max = nums.length-1;
        int midd = max/2;
        int leftIndex = -1;

        while(min<=max){
            midd = (min + max)/2;
            int curr = nums[midd];

            if(curr<target){
                min = midd +1;
            }else if (curr> target){
                max = midd - 1;
            }else{
                leftIndex = midd;
                max = midd -1;
            }

        }
        return leftIndex;
    }

}
