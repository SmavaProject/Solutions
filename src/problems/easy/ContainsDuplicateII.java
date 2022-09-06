package problems.easy;

import java.util.ArrayList;
import java.util.HashMap;

public class ContainsDuplicateII {
    /***
     * #219. Contains Duplicate II
     * https://leetcode.com/problems/contains-duplicate-ii/
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //<int>, <its indexes>
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++){
            if(!map.containsKey(nums[i])){
                ArrayList<Integer> l = new ArrayList<>();
                l.add(i);
                map.put(nums[i], l);
            }else{
                ArrayList<Integer> l = map.get(nums[i]);
                for(Integer index: l){
                    if(Math.abs(i - index)<=k){
                        return true;
                    }
                }
                l.add(i);
                map.put(nums[i], l);
            }
        }
        return false;
    }
}
