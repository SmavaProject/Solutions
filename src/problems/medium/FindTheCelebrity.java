package problems.medium;

public class FindTheCelebrity {

    /***
     * #277. Find the Celebrity - MEDIUM
     * Improved solution, runtime O(n)
     * https://leetcode.com/problems/find-the-celebrity/
     */

    public int findCelebrity(int n) {
        int possibleCelebrity = 0;
        for (int a = 1; a< n; a++){
            /*
             * celebrity does not know anyone, therefore possibleCelebrity is not a celebrity
             * and needs to be rotated.
             */
            if(knows(possibleCelebrity, a)){
                possibleCelebrity = a;
            }
        }

        /*
        * At the end, there will be only one possibleCelebrity,
        * because each API call knows(a,b) eliminates one candidate
        */

        for (int i = 0; i< n; i++){
            if(i==possibleCelebrity) continue;
            if(!knows(i, possibleCelebrity) || knows(possibleCelebrity, i)){
                return -1;
            }
        }


        return possibleCelebrity;
    }

    private boolean knows(int a, int b) {
        return true;
    }

}
