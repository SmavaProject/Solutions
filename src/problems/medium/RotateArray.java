package problems.medium;

public class RotateArray {
    /***
     * #189. Rotate Array
     * https://leetcode.com/problems/rotate-array/
     */
    public void rotate(int[] nums, int k) {

        k = k %  nums.length; // <----  to avoid rotating more times than k
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);

    }

    public void reverse(int[] nums, int start, int end){
        while(start<end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }

    }
}

/*
Основная идея в том, что после того как мы делаем rotate  элементы с конца массива перемещаются
в начало, а из начала - в конец. Но только в обратном порядке. Поэтому нам просто нужно их развернуть
k = 3
Original List                   : 1 2 3 4 5 6 7
After reversing all numbers     : 7 6 5 4 3 2 1
After reversing first k numbers : 5 6 7 4 3 2 1
After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result
*/

        /*
        Brute force solution:
        //rotate k times
        for(int i = k; i>0; i--){
            //move only last integer
            int tmp = nums[nums.length-1];//remember last int
            for(int j = nums.length-1; j>0; j--){
                nums[j] = nums[j-1];
            }
            nums[0] = tmp;
        }
        */