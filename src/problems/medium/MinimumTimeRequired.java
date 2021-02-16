package problems.medium;

/***
 * Hackerrank Binary Search - MEDIUM
 * https://www.hackerrank.com/challenges/minimum-time-required/problem
 */

/***
 * Это решение не проходит все тесткейсы, видимо из-за неправильного пере-рассчета midd и reft/right внутри while
 *
 * Идея - мы будем использовать Binary search чтобы найти нужное значение дней. Для этого нужно понять в каких границах
 * лежит наше искомое количество дней. Минимум - если все машины будут такими же быстрыми как самая быстрая(эффективная).
 * Максимум - если все мащины будут такими же медленными как самая медленная.
 */
public class MinimumTimeRequired
{
    public static long minTime(long[] machines, long goal) {
        //1. Find the efficiency of the fastest and the slowest machine
        long slowestMachineEfficiency = Integer.MIN_VALUE;
        long fastestMachineEfficiency = Integer.MAX_VALUE;
        for(long m: machines){
            slowestMachineEfficiency = Math.max(m, slowestMachineEfficiency); //6
            fastestMachineEfficiency = Math.min(m, fastestMachineEfficiency); //4
        }
        //2. Find the most anf the least possible number of days if only the slowest and the fastest machine would be used
        long upperBoundryDays =  slowestMachineEfficiency * goal / machines.length; //6*10/3=20
        long lowerBoundryDays =  fastestMachineEfficiency * goal / machines.length; //2*10/3=7

        //3. Use Binary Search to find the goal
        while(lowerBoundryDays<upperBoundryDays){
            long assumedGoalDays = (upperBoundryDays - lowerBoundryDays)/2 + lowerBoundryDays;
            long result = 0; //calculate if the goal can be produces using assumedGoalDays
            for(long m: machines){
                result = result + assumedGoalDays/m;
            }
            if(result == goal){
                return assumedGoalDays;
            }
            if(result<goal){
                lowerBoundryDays = assumedGoalDays;
            }
            if(result>goal){
                upperBoundryDays = assumedGoalDays;
            }
        }
        return 0;
    }
}
