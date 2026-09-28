package problems2.easy;

public class ContainsDuplicate {

    //https://leetcode.com/problems/contains-duplicate/

    public boolean containsDuplicate(int[] nums) {
        java.util.Set<Integer> set = new java.util.HashSet<>();
        for (int i: nums){
            set.add(i);
        }
        if (set.size() != nums.length){
            return true;
        }
        return false;
    }

}
