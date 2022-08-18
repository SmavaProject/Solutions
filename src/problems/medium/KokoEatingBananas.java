package problems.medium;

public class KokoEatingBananas {
    /***
     * #875. Koko Eating Bananas
     * https://leetcode.com/problems/koko-eating-bananas/
     */
    public int minEatingSpeed(int[] piles, int h) {
        //if(piles.length==h) return piles.length;

        //use binary search to find the speed
        //max speed is the biggest number of bananas in the pile. We cannot move faster anyways

        int minSpeed = 1;
        int maxSpeed = Integer.MIN_VALUE;

        for(int pile: piles){
            if (pile > maxSpeed){
                maxSpeed = pile;
            }
        }

        while(minSpeed<maxSpeed){
            int speed = (minSpeed + maxSpeed)/2;
            int hoursSpent = 0;
            for(int pile: piles){
                hoursSpent += (int) Math.ceil((double)pile / speed); //<<<<-------- round UP
            }

            if(hoursSpent<=h){
                maxSpeed = speed;

            }else{
                minSpeed = speed +1;
            }


        }
        return minSpeed;

    }
}
