package problems.easy;

public class FibonacciNumber {
    /***
     * #509. Fibonacci Number - easy
     * Dynamic programming
     * https://leetcode.com/problems/fibonacci-number/
     */
    public int fib(int n) {
        if(n==0 || n==1){
            return n;
        }
        int[] numbers = new int[n+1];
        numbers[0] = 0;
        numbers[1] = 1;
        for(int i=2; i< numbers.length; i++){
            numbers[i] = numbers[i-1]+numbers[i-2];
        }

        return numbers[n];
    }
}
