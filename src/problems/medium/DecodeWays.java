package problems.medium;

public class DecodeWays {
    /***
     * #91. Decode Ways
     * https://leetcode.com/problems/decode-ways/
     */
    public int numDecodings(String s) {

        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for(int i = 2; i< dp.length; i++){
            if(s.charAt(i-1)!='0'){ //dp[2], charAt(1)
                dp[i] = dp[i-1];
            }
            int twoDigits = Integer.valueOf(s.substring(i-2, i)); //i not included
            if(twoDigits>=10 && twoDigits<=26){
                dp[i] += dp[i-2];
            }

        }
        return dp[dp.length-1];


    }
}

/*
 * Решение немного похоже на climbing stairs в том смысле что это тоже dp[i] = dp[i-1] + dp[i-2] (в случае если i-2 это valid digit )
 */