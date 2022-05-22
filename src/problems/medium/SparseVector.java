package problems.medium;

import java.util.HashMap;

public class SparseVector {
    /***
     * #1570. Dot Product of Two Sparse Vectors
     * https://leetcode.com/problems/dot-product-of-two-sparse-vectors/
     */
    public HashMap<Integer, Integer> map;
    public int len;
    SparseVector(int[] nums) {
        this.map = new HashMap<>();
        for (int i = 0; i< nums.length; i++){
            if(nums[i]!=0){
                this.map.put(i, nums[i]);
                this.len = i;
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int minLen = Math.min(this.len, vec.len); // <<<<------ find MIN len of 2 vectors. We dont care about the rest
        int product = 0;
        for(int i = 0; i<=minLen; i++){
            int a = this.map.containsKey(i) ? this.map.get(i) : 0;
            int b = vec.map.containsKey(i) ? vec.map.get(i) : 0;
            product += a*b;
        }
        return product;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
