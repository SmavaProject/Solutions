package problems.easy;

import java.util.ArrayList;

public class ArmstrongNumber {
    /***
     * #1134. Armstrong Number
     * https://leetcode.com/problems/armstrong-number/
     */

    public boolean isArmstrong(int n) {
        int nCopy = n;
        ArrayList<Integer> digits = new ArrayList<>();

        while(nCopy >= 10){
            int rest = nCopy % 10;
            digits.add(rest);
            nCopy = nCopy/10;
        }
        digits.add(nCopy);

        int power = digits.size();
        int sum = 0;

        for(Integer i : digits){
            sum+= Math.pow(i, power);
        }
        return n == sum;

    }
}