package problems.easy;

import java.util.Arrays;

public class MergeSortedArray {

    /***
     * #88. Merge Sorted Array - EASY
     *
     * https://leetcode.com/problems/merge-sorted-array/
     */

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int n1Pointer = m -1;
        int n2Pointer = n -1;

        for (int i = nums1.length -1; i>=0; i-- ){
            if(n2Pointer<0){ //<----- nums2 is done, а первые элементы nums1 и так на своем месте => выходим из loop
                break;
            }
            if(n1Pointer<0){ //<----- nums1 is done, нужно докопировать nums2 в начало
                nums1[i] = nums2[n2Pointer];
                n2Pointer--;
                continue;
            }
            if(nums1[n1Pointer]>= nums2[n2Pointer]){
                nums1[i] = nums1[n1Pointer];
                n1Pointer--;
            }else{
                nums1[i] = nums2[n2Pointer];
                n2Pointer--;
            }
        }

    }

    /**
     * easier solution using extra space:
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {

        int[] nums1Clean = Arrays.copyOf(nums1, m);
        int nums2Pointer = 0;
        int nums1Pointer = 0;
        int index = 0;


        while(nums1Pointer<nums1Clean.length && nums2Pointer<nums2.length && index<nums1.length){
            if(nums1Clean[nums1Pointer]<=nums2[nums2Pointer]){
                nums1[index] =nums1Clean[nums1Pointer];
                nums1Pointer++;
            }else{
                nums1[index] =nums2[nums2Pointer];
                nums2Pointer++;
            }
            index++;
        }
        while(nums1Pointer<nums1Clean.length && index<nums1.length){
            nums1[index] =nums1Clean[nums1Pointer];
            nums1Pointer++;
            index++;
        }
        while(nums2Pointer<nums2.length && index<nums1.length){
            nums1[index] =nums2[nums2Pointer];
            nums2Pointer++;
            index++;
        }


    }
}
