package problems.easy;

import java.util.HashSet;

public class MakeArrayZeroBySubtractingEqualAmounts {
    /***
     * #2357. Make Array Zero by Subtracting Equal Amounts
     * https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/
     */
    public int minimumOperations(int[] nums) {
        //ответ равен количеству уникальных цифр (не равных нулю)
        HashSet<Integer> uniqueInt = new HashSet<>();
        for(int i: nums){
            if(i!=0)
                uniqueInt.add(i);
        }
        return uniqueInt.size();
    }
}
