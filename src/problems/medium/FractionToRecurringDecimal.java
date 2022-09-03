package problems.medium;

import java.util.HashMap;

public class FractionToRecurringDecimal {
    /***
     * #166. Fraction to Recurring Decimal
     * https://leetcode.com/problems/fraction-to-recurring-decimal/
     */

    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0) return "0";

        StringBuilder result = new StringBuilder();
        if((numerator<0 ||denominator<0) && !(numerator<0 && denominator<0)){
            result.append("-");
        }
        long numeratorL = Math.abs(Long.valueOf(numerator));
        long denominatorL = Math.abs(Long.valueOf(denominator));

        Long remainder = numerator % denominatorL;

        result.append(String.valueOf(Math.abs(numeratorL / denominatorL)));

        if(remainder == 0){
            return result.toString();
        }
        result.append(".");
        HashMap<Long, Integer> remaindersMap = new HashMap<>();

        while(remainder != 0){
            if(remaindersMap.containsKey(remainder)){ //divider starts repeating, thus - take it into braces
                Integer place = remaindersMap.get(remainder);
                result.insert(place, "(");
                result.append(")");
                break;
            }
            Integer placeWhereRemindredIsFound = result.length();
            remaindersMap.put(remainder, placeWhereRemindredIsFound);
            remainder = remainder * 10;
            result.append(String.valueOf(Math.abs(remainder / denominatorL)));
            remainder = remainder % denominator;

        }


        return result.toString();
    }
}
