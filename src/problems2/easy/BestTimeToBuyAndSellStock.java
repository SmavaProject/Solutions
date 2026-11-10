package problems2.easy;

public class BestTimeToBuyAndSellStock {

    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

    public int maxProfit(int[] prices) {
        int minValue = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i< prices.length; i++){
            int curr = prices[i];
            int currProfit = (curr - minValue) ;
            maxProfit = Math.max(maxProfit, currProfit);

            if(curr < minValue){
                minValue = curr;
            }
        }

        return maxProfit;
    }

}
