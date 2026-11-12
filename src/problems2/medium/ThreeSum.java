package problems2.medium;

public class ThreeSum {

    //https://leetcode.com/problems/3sum/description/

    public List<java.util.List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new java.util.ArrayList<>();
        if(nums.length == 3){
            if((nums[0]+ nums[1] + nums[2]) == 0) {
                List<Integer> r = new java.util.ArrayList<>();
                r.add(nums[0]);
                r.add(nums[1]);
                r.add(nums[2]);
                result.add(r) ;
                return result;
            }
        }

        Set<List<Integer>> res = new java.util.HashSet<>();

        java.util.Arrays.sort(nums);

        for(int i = 0; i< nums.length - 1; i++){
            int first = nums[i];
            int rem = 0 - first;
            int j = i +1;
            int k = nums.length -1;
            while(j<k){
                int second = nums[j];
                int third = nums[k];
                if((first + second + third) == 0){
                    java.util.List<Integer> r = new java.util.ArrayList<>();
                    r.add(first);
                    r.add(second);
                    r.add(third);
                    res.add(r);
                    j ++;
                    k --;
                } else if ((second + third) < rem){
                    j ++;
                } else{
                    k --;
                }
            }

        }



        return new java.util.ArrayList<>(res);

    }

}
