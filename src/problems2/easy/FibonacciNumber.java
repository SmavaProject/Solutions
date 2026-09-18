package problems2.easy;

public class FibonacciNumber {

    //https://leetcode.com/problems/fibonacci-number/description/

    public static int[] array;
    public int fib(int n) {
        if (n == 0 || n == 1) return n;
        if (n == 2) return 1;

        array = new int[n+1];
        for (int i = 0; i< array.length; i++){
            array[i] = -1;
        }
        array[0] = 0;
        array[1] = 0;
        array[2] = 1;
        int s = array.length;
        return rec(n);
    }

    public int rec(int n){
        if (n == 0 || n == 1) return n;
        if (n == 2) return 1;
        if (array[n]!= -1 ) return array[n];

        int res = rec(n-1) + rec(n-2);
        array[n] = res;
        return res;
    }

}
