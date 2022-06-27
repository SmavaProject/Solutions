package problems.hard;

public class FirstMissingPositive {
    /**
     * 41. First Missing Positive
     * https://leetcode.com/problems/first-missing-positive/
     */
    /**
     * Важно:
     Нам нужно найти First Missing ""Positive"" integer !!! поэтому:
     1) we dont care about negative integers and 0 at all
     2) n = nums.length, If a positive integer is not in the given array it, the missing integer must be in the range [1..n]
     *
     Algorithm:

     Check if 1 is present in the array. If not, you're done and 1 is the answer.
     Replace negative numbers, zeros, and numbers larger than n by 1s.
     Walk along the array. Change the sign of a-th element if you meet number a. Be careful with duplicates : do sign change only once. Use index 0 to save an information about presence of number n since index n is not available.
     Walk again along the array. Return the index of the first positive element.
     If nums[0] > 0 return n.
     If on the previous step you didn't find the positive element in nums, that means that the answer is n + 1.

     */
    public int firstMissingPositive(int[] nums) {

        int n  = nums.length;

        boolean is1Found = false;
        for(int i = 0; i< n; i++){
            int current = nums[i];
            if(current == 1) is1Found = true;
            if(current <= 0 || current > n){
                nums[i] = 1;
            }
        }

        if(!is1Found) return 1;

        for(int i = 0; i< n; i++){
            int current = nums[i]; //e.g. 3 -> nums[3] = - nums[3]
            if(Math.abs(current)==n){ //handle n
                nums[0] = -nums[0];
            } else if(nums[Math.abs(current)]>0){
                nums[Math.abs(current)] = - nums[Math.abs(current)];
            }
        }



        int result = n+1;
        for (int i = 1; i< n; i++){
            if(nums[i]>0){
                return i;
            }
        }

        if(nums[0]>0) return n; //handle n

        return result;
    }
}

/*
* Пример1:
[1,2,0] ->
[1,-2,-1] ->
return 3

* Пример2:
[3,4,-1,1] ->
[3,4,1,1] ->
[-3,-4,1,-1] ->
return 2

* Пример3:
[7,8,9,11,12] ->
[1,1,1,1,1] ->
is1Found = false ->
return 1
*
*/