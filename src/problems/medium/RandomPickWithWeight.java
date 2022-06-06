package problems.medium;

public class RandomPickWithWeight {
        /**
         * #528. Random Pick with Weight
         * https://leetcode.com/problems/random-pick-with-weight/
         * PREFIX SUM
         */

        int[] prefixSum;
        int totalSum;

        public RandomPickWithWeight(int[] w) {
            this.prefixSum = new int[w.length];
            int cumulativeSum = 0;
            for(int i = 0; i< this.prefixSum.length;i++){
                cumulativeSum += w[i];
                prefixSum[i] = cumulativeSum;
            }
            totalSum = cumulativeSum;
        }

        public int pickIndex() {
            //for debugging
            //int[] prefixSum2 = this.prefixSum;
            //int sum = this.totalSum;
            double target = Math.random()*this.totalSum; //<<---- (!)
            for(int i = 0; i< prefixSum.length; i++){
                if(target<this.prefixSum[i]){ //<<---- (!)
                    return i;
                }
            }
            return -1; //should never be reached
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */



