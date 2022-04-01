package problems.medium;

public class FindTheCelebrityBruteforce {
    /***
     * #277. Find the Celebrity - MEDIUM
     * Brute force solution
     * https://leetcode.com/problems/find-the-celebrity/
     */
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

    public class Solution  {
        public int findCelebrity(int n) {
            boolean [] knownByEveryone = new boolean[n];
            boolean[] knowsSomebody = new boolean[n];
            for (int i = 0; i< knownByEveryone.length; i++){
                knownByEveryone[i] = true;
                knowsSomebody[i] = false;
            }
            for (int a = 0; a< n; a++){
                for (int b = 0; b< n; b++){
                    if(a!=b){
                        if(knows(a, b)){
                            knowsSomebody[a] = true;
                        }else{ // a does not know b
                            knownByEveryone[b]= false;
                        }
                    }
                }
            }
            for (int i = 0; i< n; i++){
                if(knownByEveryone[i] && !knowsSomebody[i]) return i;
            }

            return -1;
        }

        private boolean knows(int a, int b) {
            return true;
        }
    }
}
