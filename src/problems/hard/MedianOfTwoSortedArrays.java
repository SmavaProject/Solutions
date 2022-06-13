package problems.hard;

public class MedianOfTwoSortedArrays {
    /***
     * #4. Median of Two Sorted Arrays
     * https://leetcode.com/problems/median-of-two-sorted-arrays/
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int middPoint = (nums1.length + nums2.length)/2;
        //!!!! обязательно length, не привязываться к middPoint
        boolean isLenEven = (nums1.length + nums2.length) % 2 == 0 ? true : false; //четный
        int pointer1 = 0;
        int pointer2 = 0;
        double num1 = 0;
        double num2 = 0;

        while(pointer1<nums1.length && pointer2<nums2.length && (pointer1+pointer2) <=middPoint){
            if(nums1[pointer1] <=nums2[pointer2]){
                if(isLenEven){
                    num2 = num1;
                    num1 = nums1[pointer1];
                }else{
                    num1 = nums1[pointer1];
                }

                pointer1++;
            }else{
                if(isLenEven){

                    num2 = num1;
                    num1 = nums2[pointer2];
                }else{
                    num1 = nums2[pointer2];
                }
                pointer2++;
            }

        }
        // array 2 is over
        while(pointer1<nums1.length && (pointer1+pointer2) <=middPoint){
            if(isLenEven){
                num2 = num1;
                num1 = nums1[pointer1];
            }else{
                num1 = nums1[pointer1];
            }
            pointer1++;
        }
        //array 1 is over
        while(pointer2<nums2.length && (pointer1+pointer2) <=middPoint){
            if(isLenEven){
                num2 = num1;
                num1 = nums2[pointer2];
            }else{
                num1 = nums2[pointer2];
            }
            pointer2++;
        }

        return isLenEven ? (num1+num2)/2 : num1;
    }
}
}
