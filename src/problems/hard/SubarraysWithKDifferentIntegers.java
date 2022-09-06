package problems.hard;

import java.util.HashMap;

public class SubarraysWithKDifferentIntegers {
    /***
     * #992. Subarrays with K Different Integers
     * https://leetcode.com/problems/subarrays-with-k-different-integers/
     * solution: https://leetcode.com/problems/subarrays-with-k-different-integers/discuss/547450/Java-_-Well-Explained
     */
    public int subarraysWithKDistinct(int[] nums, int k) {

        return subarraysWithAtMostKDistinct(nums, k) - subarraysWithAtMostKDistinct(nums, k-1);
    }

    public int subarraysWithAtMostKDistinct(int[] nums, int k) {
        int start = 0;
        int result = 0;
        int numberOfUniqueInt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int end = 0; end< nums.length; end++){
            int count = map.getOrDefault(nums[end], 0);
            if(count == 0) numberOfUniqueInt++;

            map.put(nums[end], count + 1);

            while(numberOfUniqueInt > k){
                int stCount = map.get(nums[start]);
                if(stCount - 1 == 0){
                    map.remove(nums[start]);
                    numberOfUniqueInt--;
                } else{
                    map.put(nums[start],stCount - 1 );
                }
                start++;
            }

            result += end - start +1; //<<-- All subarrays between end and start, boundaries included are subarrays with AT MOST k characters, including each subarray of length 1 and so on.
        }
        return result;
    }


}

/*
1. Тк это сложно посчитать количество уникальных Subarrays длинной ровно К, мы посчитаем количеество уникальных Subarrays длинной К и меньше,
а потом отнимем количеество уникальных Subarrays длинной К-1 и меньше и получим ровно К.
2. Переменная numberOfUniqueInt считает сколько уникальных цифр в нашем текущем  Subarray. Как только мы превыщаем К мы начинаем сужать window
3. Subarray длинной в 1 элемент это тоже Subarray

*/