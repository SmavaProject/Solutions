package problems.easy;

/***
 * # 121 https://leetcode.com/problems/best-time-to-buy-and-sell-stock/ - EASY
 * O(n) - we can solve it in one run
 *
 * The best time to buy and sell stocks is the difference between the lowest price
 * and the highest price on the price chart.
 *
 * For every price we need to find the difference between previous most min price and
 * a current price
 */

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i =0; i< prices.length; i++){
            //check maybe a current element is the most min price
            if(prices[i]< minPrice){
                minPrice = prices[i];
            }
            maxProfit = prices[i] - minPrice > maxProfit ? prices[i] - minPrice : maxProfit;
        }
        return maxProfit;
    }
}
