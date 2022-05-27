package problems.hard;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {
    /***
     * #354.Russian Doll Envelopes
     * https://leetcode.com/problems/russian-doll-envelopes/
     */

    //#1) DP. N(O2) - time limit exceeded
    public int maxEnvelopes(int[][] envelopes) {
        int res = 1;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            //sort by first than by second element
            @Override
            public int compare(int[] a1, int[]a2){
                if(a1[0]==a2[0]){
                    return a1[1]-a2[1];
                }
                return a1[0]-a2[0];
            }
        });
        int[] dp = new int[envelopes.length];
        for (int i = 0; i< dp.length; i++){ //mark every cell as 1, because we at least have 1 envelope as our result
            dp[i]=1;
        }

        for(int i = 0; i< envelopes.length; i++){
            int[] curr = envelopes[i];
            for(int j = 0; j<i; j++){
                int[] prev = envelopes[j];
                if(curr[1]>prev[1] && curr[0]>prev[0]){ //<----
                    int maxEnv = Math.max(dp[j] +1, dp[i]); //<----
                    dp[i] = maxEnv;
                    res = Math.max(res, maxEnv);
                }

            }
        }

        return res;
    }
}
