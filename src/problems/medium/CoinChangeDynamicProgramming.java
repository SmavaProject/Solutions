package problems.medium;

public class CoinChangeDynamicProgramming {
    /***
     * 322. Coin Change
     * https://leetcode.com/problems/coin-change/
     */
    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        int[] amounts = new int[amount+1];
        return  rec(coins, amount, amounts);
    }

    public int rec(int[] coins, int amount,int[] amounts){
        if(amount == 0) return 0;
        if(amount < 0) return -1;
        if(amounts[amount] != 0) return amounts[amount];

        int minCoins = Integer.MAX_VALUE; // <<<------------ (!!!) DON'T pass it in the function signature
        for (int coin: coins){
            int currMin = rec(coins, amount-coin, amounts);
            if(currMin>=0 && currMin<minCoins){//update ONLY if (currMin < minCoins).  NOT: Math.min(minCoins, currMin) +1
                minCoins = currMin +1;
            }
        }

        amounts[amount] = minCoins == Integer.MAX_VALUE ? -1 :  minCoins;
        return amounts[amount];
    }

}
