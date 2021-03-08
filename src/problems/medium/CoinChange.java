package problems.medium;

import java.util.Arrays;

/***
 * https://leetcode.com/problems/coin-change/ #322 MEDIUM
 * Dynamic Programming, bottom up -?
 * https://www.youtube.com/watch?v=1R0_7HqNaW0
 */
public class CoinChange
{
    /***
     * IMPORTANAT: dont fill  the array with Integer.MAX_VALUE. because of "1+" on  line  29 there will be stack overflow
     * Create  the array minNumberOfCoins where we store all solutions for smaller subproblems starting with  subproblem
     * amount==0.
     * Line 29:
     * MinNumberOfCoins is either current min, or we can take current coin J and add the min for the amount without J. Add 1 to count J
     * (1+ minNumberOfCoins[i - coins[j]). The amount without J is already  calculated and stored in the array minNumberOfCoins
     */
    public int coinChange(int[] coins, int amount) {
        int[] minNumberOfCoins = new int[amount+1];
        Arrays.fill(minNumberOfCoins, amount+1);
        Arrays.sort(coins); //optimization. we dont have to sort, it will work without sorting
        minNumberOfCoins[0] = 0;

        for(int i = 0; i<= amount; i++){
            for(int j = 0; j< coins.length; j++){
                if(i>=coins[j]){
                    minNumberOfCoins[i] = Math.min(minNumberOfCoins[i], 1+ minNumberOfCoins[i - coins[j]]);
                }else{
                    break; // optimization. Because the coins are sorted
                }
            }
        }
        return minNumberOfCoins[amount] > amount ? -1 : minNumberOfCoins[amount];
    }
}
