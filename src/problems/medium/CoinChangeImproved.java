package problems.medium;

public class CoinChangeImproved {
    /***
     * 322. Coin Change
     * It works correctly, but does not pass the Leetcode, TimeLimitExceeded
     * https://leetcode.com/problems/coin-change/
     */
    public int coinChange(int[] coins, int amount) {
        return  rec(coins, amount, Integer.MAX_VALUE);
    }

    public int rec(int[] coins, int amount, int minCoins){
        if(amount == 0){
            return 0;
        }

        for (int coin: coins){
            if(amount - coin >=0){
                int currMin = rec(coins, amount-coin, minCoins); //subtract coin value from the amount
                if(currMin!=-1){
                    minCoins = Math.min(minCoins, currMin);
                }
            }
        }

        return minCoins == Math.abs(Integer.MAX_VALUE) ? -1 :  (minCoins + 1); // minCoins +1 <<-- here we increment the number
    }
}

