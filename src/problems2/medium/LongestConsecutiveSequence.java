package problems2.medium;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        //https://leetcode.com/problems/longest-consecutive-sequence/

        java.util.Set<Integer> set = new java.util.HashSet<>();
        for (int n: nums){
            set.add(n);
        }

        int longest = 0;
        //start building a sequence from every possible number
        for (int num: nums){
            if(set.contains(num-1)) continue; //no need to try builing sequence from this number, we will try doing it from a smaller number
            int currLen = 1;
            int currNum = num;

            while (set.contains(currNum + 1)){
                currNum++;
                currLen++;
            }
            longest = Math.max(longest, currLen);
        }

        return longest;
    }

}
