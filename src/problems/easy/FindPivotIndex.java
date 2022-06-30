package problems.easy;

public class FindPivotIndex {
    /***
     * #724 Find Pivot Index
     *
     */

    //1) long intuitive solution
    public int pivotIndex(int[] nums) {
        if(nums.length == 1){
            return 0;
        }

        int[] forward = new int[nums.length];
        forward[0] = nums[0];
        for(int i = 1; i< nums.length; i++){
            forward[i] = forward[i-1] + nums[i];
        }

        int[] backward = new int[nums.length];
        backward[nums.length-1] = nums[nums.length-1];
        for(int i = nums.length-2;i>=0; i--){
            backward[i] = backward[i+1] + nums[i];
        }

        //check first element
        if(backward[1]==0) return 0;


        for(int i = 1; i< nums.length - 1; i++){
            if(forward[i-1] == backward[i+1]){
                return i;
            }
        }

        //check last element
        if(forward[nums.length-2]==0) return nums.length-1;


        return -1;

    }

    /*
    Если от полной суммы всех чисел отнять текущую сумму левых элементов то получится nums[i]
     */
    // 2) shorter solution
    public int pivotIndex1(int[] nums) {

        int leftSum = 0;
        int totalSum = 0;
        for(int i = 0; i< nums.length; i++){
            totalSum += nums[i];
        }

        for(int i = 0; i< nums.length; i++){
            if(leftSum == totalSum - nums[i] - leftSum){
                return i;
            }
            leftSum += nums[i]; //<<<---
        }


        return -1;

    }
}
