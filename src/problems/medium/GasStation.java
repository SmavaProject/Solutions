package problems.medium;

public class GasStation {
    /***
     * #134. Gas Station
     * https://leetcode.com/problems/gas-station/
     */

    //#1 Brute force O(n)
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i = 0; i< gas.length; i++){
            int start = i;
            //int end = start == 0 ? gas.length -1 : start -1; <-- wrong
            int end = start;
            int tank = 0;
            while(true){
                int totalGas = tank + gas[start];
                int currCost = cost[start];
                if(totalGas - currCost>=0){
                    start = start == gas.length -1 ? 0 : start + 1;
                    tank = totalGas - currCost;
                }else{
                    break;
                }
                if(start == end){
                    return i;
                }
            }
        }
        return -1;
    }

    //#2 Linear complexity O(n)
    public int canCompleteCircuit1(int[] gas, int[] cost) {

        /*
        * 1) If totalCosts > totalGas - there is no solution.
        * 2) If totalCosts >= totalGas - the solution exists.
        The tank should never be negative. When it is negative, it means that we don't have enough gas to go to the next point. Therefore, we reset starting point
        */
        int start = 0;
        int totalGas = 0;
        int totalCosts = 0;
        int currentTank = 0;

        for(int i = 0; i< gas.length; i++){

            totalGas = totalGas+ gas[i];
            totalCosts = totalCosts + cost[i];
            currentTank = currentTank + gas[i] - cost[i];

            if(currentTank<0){
                start = i+1;
                currentTank = 0;
            }



        }
        return totalCosts > totalGas ? -1 : start;
    }
}
