package problems.medium;

import java.util.HashMap;

public class ContiguousArray {
    /**
     * #525. Contiguous Array
     * https://leetcode.com/problems/contiguous-array/
     * Prefix sum
     */
    public int findMaxLength(int[] nums) {
        //<sum, index>
        HashMap<Integer, Integer> map = new HashMap<>();

        int maxLen = 0;
        int prefixSum = 0;
        for(int i = 0; i< nums.length;i++){
            //add 1 or subtract -1 for 0 value
            prefixSum += nums[i]==1? 1 : -1;
            if(prefixSum == 0){ // работает и без этого условия
                maxLen = Math.max(maxLen, i +1);
            }else if(map.containsKey(prefixSum)){
                maxLen = Math.max(maxLen, i - map.get(prefixSum)); //<<---
            }else{
                map.put(prefixSum, i);
            }

        }
        return maxLen;
    }
}
/***
 * 1) Посчитай prefixSum таким образом, чтобы добавлять 1 каждый раз когда видим 1 и отнимать -1 когда видим 0
 * 2) Пройти по всем nums, если мы встречаем 0 или 2 раза одно и то же значение prefixSum, это значит что мы
 * нашли сбалансированный отрезок nums
 * 3) Для удобства сохраняй значения prefixSum и на каком элементе она была посчитана
 */
