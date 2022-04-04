package problems.easy;

public class MinCostClimbingStairs {
    /***
     * 746. Min Cost Climbing Stairs - Easy
     * https://leetcode.com/problems/min-cost-climbing-stairs/
     * Dynamic programming
     */

    public int minCostClimbingStairs(int[] cost) {
        int[] minCost = new int[cost.length];
        /*
        Минимальная стоимость чтобы забраться на нулевую или первую ступеньку равна стоимости из cost[0] или cost[1]
         */
        minCost[0]=cost[0];
        minCost[1]=cost[1];

        /*
        Минимальная стоимость забраться на ступеньку i - это стоимость этой ступеньки cost[i] плюс один из вариантов -
        шагнуть на нее из -1й или -2й ступеньки
         */
        for (int i = 2; i< cost.length; i++){
            minCost[i] = cost[i] + Math.min(minCost[i-1], minCost[i-2]);
        }

        /*
        Нам нужно "забраться" на самый верх, это можно сделать с последней или предпоследней ступеньки
         */
        return Math.min(minCost[cost.length-1], minCost[cost.length-2]);
    }
}
