package problems.easy;

import java.util.Arrays;

/***
 * https://www.hackerrank.com/challenges/mark-and-toys/problem - EASY
 * Sorting
 */
public class MarkAndToys
{
    static int maximumToys(int[] prices, int k) {
        int result = 0;
        if(prices.length<1){
            return result;
        }
        Arrays.sort(prices);
        int index = 0;
        while(k>0 && index<prices.length){
            int currToyPrice = prices[index];
            if(k-currToyPrice > 0){
                result++;
            }
            k = k-currToyPrice;
            index++;
        }
        return result;

    }
}
