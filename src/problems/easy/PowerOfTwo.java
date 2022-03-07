package problems.easy;

public class PowerOfTwo {
    /***
     * #231. Power of Two
     *  https://leetcode.com/problems/power-of-two/
     */

    public boolean isPowerOfTwo(int n) {
        return isPowerOfTwoDouble(n);
    }

    public boolean isPowerOfTwoDouble(double n) {
        if(n==1){
            return true;
        }
        if(n<1){
            return false;
        }
        return isPowerOfTwoDouble(n/2);
    }

}
