package problems.medium;

public class JumpGame {
    /**
     * #55. Jump Game - MEDIUM
     * Dynamic prgramming
     * https://leetcode.com/problems/jump-game/
     */


    /**
     * Важно:
     * 1) присваивать значение canJump[index] = 1; только после того как рекурсия if(recursion1(nums, index + i, canJump) == 1)
     * вернула значение 1
     */

    public boolean canJump1(int[] nums) {
        if(nums.length==1)return true;
        //-1, 0, 1
        //0 -unnknown, 1 can reach, -1 cannot reach
        int[] canJump = new int[nums.length];
        canJump[canJump.length-1] =1; // only the last position is marked as 1, as leading to finish
        recursion1(nums, 0, canJump);
        return canJump[0]==1 ? true : false;

    }

    public int recursion1(int[] nums, int index, int[] canJump) {
        if(canJump[index]!=0){
            return canJump[index];
        }

        int currentOptions = nums[index];
        for(int i = 1; i<=currentOptions; i++){
            if(index + i <= canJump.length-1){
                if(recursion1(nums, index + i, canJump) == 1){ //<<<<--------------------
                    canJump[index] = 1; //<<<<----------------
                    return 1;
                }
            }
        }
        canJump[index] = -1;
        return -1;
    }
}
    /*

    //DP top-down, time limit exceeded
    public boolean canJump(int[] nums) {
        if(nums.length==1)return true;
        boolean[] canJump = new boolean[nums.length];//all values are false by default
        recursion(nums, 0, canJump);
        return canJump[canJump.length-1];

    }

    public void recursion(int[] nums, int index, boolean[] canJump) {
        if(index >=nums.length-1){
            canJump[canJump.length-1] =true;
            return;
        }
        canJump[index] = true; // <----- (((((((((((((((((((((((:
        int currentOptions = nums[index];
        for(int i = 1; i<=currentOptions; i++){
            if((index + i <= canJump.length-1)&& canJump[index + i] == false){
                recursion(nums, index + i, canJump);
            }
        }
    }
}
*/