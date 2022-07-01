package problems.medium;

public class PaintHouse {
    /***
     * #256. Paint House
     * https://leetcode.com/problems/paint-house/
     */

    //Option 1: recursive. Time limit exceeded
    public int minCost(int[][] costs) {

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            int currMin = costs[0][i] + recursion(costs, 1, i);
            min = Math.min(min, currMin);
        }
        return min;
    }

    private int recursion(int[][] costs, int index, int prev) {
        if (index == costs.length) return 0;

        int[] currentValues = costs[index];
        int minOption = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (i != prev) {
                int opt = currentValues[i] + recursion(costs, index + 1, i);
                minOption = Math.min(minOption, opt);
            }
        }

        return minOption;

    }


    /***
     * Dynamic programming
     */
    public int minCost1(int[][] costs) {

        int[][] dp = new int[costs.length][3];
        int min = Integer.MAX_VALUE;
        for(int i = 0; i< 3; i++){
            int currMin = costs[0][i] + recursion1(costs, 1, i, dp);
            min = Math.min(min, currMin);
        }
        return min;
    }

    private int recursion1(int[][] costs, int index, int prev, int[][] dp){
        if(index == costs.length) return 0;

        int[] currentValues = costs[index];
        int minOption = Integer.MAX_VALUE;
        for (int i = 0; i< 3; i++){
            if(i!= prev){
                if(dp[index][i]==0){
                    int opt = currentValues[i] + recursion1(costs, index +1, i, dp);
                    dp[index][i] = opt;
                    minOption = Math.min(minOption, opt);

                }else{
                    minOption = Math.min(minOption, dp[index][i]);
                }
            }
        }

        return minOption;

    }

}
