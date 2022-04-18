package problems.medium;

public class MaximumProductSubarray {
    /***
     * #152. Maximum Product Subarray - MEDIUM
     * Dynamic programming
     * https://leetcode.com/problems/maximum-product-subarray/
     */

    /*
     * Possible cases:
     * 1) All numbers are positive => simply multiply the numbers
     * 2) We encounter 0 => reset the sequence, remember current maxProd
     * 3) We encounter a negative number => continue multiplying the numbers, hope to
     * find another negetive number and flip it to the positive product
     */
    public int maxProduct(int[] nums) {
        if(nums.length==0)return 0;
        int currMax = nums[0];
        int currMin = nums[0];
        int maxProd = nums[0];

        for(int i = 1; i< nums.length; i++){
            int TMP_MAX = Math.max(nums[i], Math.max(nums[i]*currMax, nums[i]*currMin));// <<<---------(!!!)
            currMin = Math.min(nums[i], Math.min(nums[i]*currMax, nums[i]*currMin));

            currMax = TMP_MAX; // <<<-------------------------(!!!)
            maxProd = Math.max(maxProd, currMax);


        }
        return maxProd;
    }
}

/***
 * 1) И для рассчета currMax и для рассчета currMin мы должны использовать max/min из (nums[i]*currMax, nums[i]*currMin),
 * тк в зависимости от знака nums[i] значение произведения может стать либо очень больщим либо очень маленьким
 * 2) Обязательно нужно использовать TMP_MAX, иначе при рассчете currMin мы будем использовать уже измененный currMax
 * и цепочка nums может быть прервана
 */
