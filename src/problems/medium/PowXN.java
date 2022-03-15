package problems.medium;

public class PowXN {
    /***
     * #50. Pow(x, n) - MEDIUM
     * Recursion
     * https://leetcode.com/problems/powx-n/
     */

    public double myPow(double x, int n) {
        if(n<0){ //flip x and n, так проще всего
            x = 1/x;
            n=-n;
        }
        return powDevided(x, n);
    }

    // благодаря этому complexity: O(logn)
    public double powDevided(double x, int n) {
        if(n == 0){
            return 1;
        }
        if(n==1){
            return x;
        }
        double half = powDevided(x, n/2);
        if(n%2==0){ // обязательное условие
            return half * half;
        }else{
            return x* half * half;
        }
    }
}

