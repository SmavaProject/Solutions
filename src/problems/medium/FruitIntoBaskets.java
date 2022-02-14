package problems.medium;

import java.util.HashMap;

public class FruitIntoBaskets {
    /**
     * # 904. Fruit Into Baskets - MEDIUM
     * https://leetcode.com/problems/fruit-into-baskets/
     *
     * https://www.educative.io/courses/grokking-the-coding-interview/Bn2KLlOR0lQ
     */
    public int totalFruit(int[] fruits) {

        int start = 0;
        int bestResult = 0;

        //<tree type, number of collected fruits>
        HashMap<Integer, Integer> fruitsMap = new HashMap<>();


        for (int end = 0; end < fruits.length; end++){
            fruitsMap.put(fruits[end], fruitsMap.getOrDefault(fruits[end], 0)+1);

            if (fruitsMap.size()>2){
                if(fruitsMap.get(fruits[start]) == 1){
                    fruitsMap.remove(fruits[start]);
                }else{
                    fruitsMap.put(fruits[start], fruitsMap.get(fruits[start]) -1);
                }

                start++;
            }

            int currentResult = fruitsMap.values().stream().reduce(0, Integer::sum);

            bestResult = Math.max(bestResult, currentResult);
        }

        return bestResult;
    }
}
