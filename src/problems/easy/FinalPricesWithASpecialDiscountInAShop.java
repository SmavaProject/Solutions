package problems.easy;

import java.util.Stack;

public class FinalPricesWithASpecialDiscountInAShop {
    /***
     * #1475. Final Prices With a Special Discount in a Shop
     * https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/
     * Monotonic stack
     */

    // brute force solution, O(n2)
    public int[] finalPrices(int[] prices) {
        int[] res = new int[prices.length];

        for (int i = 0; i< prices.length; i++){
            int currI = prices[i];
            int discount = 0;
            for(int j = i+1; j< prices.length; j++){
                if(prices[j]<=currI){
                    discount = prices[j];
                    break;
                }
            }
            res[i] = currI - discount;
        }
        return res;
    }

    /*
     * monoIncreasingStack - O(n)
     * Задача сводится к поиску следующего меньшего элемента
     * => используем Stack в котором все элементы только увеличиваются (до тех пор пока мы
     * не нашли первый меньший элемент чтобы посчитать скидку)
     */
    public int[] finalPrices1(int[] prices) {
        Stack<int[]> monoIncreasingStack = new Stack<>();
        int index = 0;
        int[] result = new int[prices.length];
        for (int i = 0; i< prices.length; i++){
            int currPrice = prices[i];
            while(!monoIncreasingStack.isEmpty() && monoIncreasingStack.peek()[1]>=currPrice){ //<<<<----------
                int[]prev = monoIncreasingStack.pop();
                result[prev[0]] = prev[1]- currPrice;
            }
            monoIncreasingStack.push(new int[]{i, currPrice});
        }
        while(!monoIncreasingStack.isEmpty()){ //<<<<---------- elements without discount
            int[]elementWithoutDiscount = monoIncreasingStack.pop();
            result[elementWithoutDiscount[0]] = elementWithoutDiscount[1];
        }
        return result;
    }
}
