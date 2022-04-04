package problems.easy;

/***
 * https://leetcode.com/problems/climbing-stairs/  #70 EASY
 * Dynamic programming
 * Важдно распознать зависимость на стр 25 как в Фибоначи
 * Забраться на ступеньку n это сумма всех опций как забраться на ступеньку n-1 и n-2
 */
public class ClimbStairs
{
    public int climbStairs(int n) {
        if(n == 0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int[] numberOfStairs = new int[n+1];
        numberOfStairs[0] = 0;
        numberOfStairs[1] = 1;
        numberOfStairs[2] = 2;
        for (int i = 3; i<= n; i++){
            numberOfStairs[i] =numberOfStairs[i-1] + numberOfStairs[i-2];
        }
        return numberOfStairs[n];
    }
}


/***
 * n=1 => 1 (1)
 * n=2 => 2 (1+1, 2)
 * n=3 => 3 (1+2, 2+1, 1+1+1)
 * n=4 => 5 (2+2, 1+2+1, 1+1+2, 2+1+1, 1+1+1+1)
 */

