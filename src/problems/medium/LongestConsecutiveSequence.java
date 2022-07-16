package problems.medium;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    /***
     * #128. Longest Consecutive Sequence
     * https://leetcode.com/problems/longest-consecutive-sequence/
     *
     * HasSet. O(n) complexity
     */

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longestSeq = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!set.contains(num - 1)) { //<-- if set contains num -1 we already calucalted this num in some previous sequence
                int currentSeq = 0;

                while (set.contains(num)) {
                    currentSeq++;
                    num++;
                }
                longestSeq = Math.max(longestSeq, currentSeq);
            }
        }
        return longestSeq;
    }

}
