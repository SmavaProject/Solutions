package problems.easy;

/***
 * https://leetcode.com/problems/find-the-town-judge/ #997 EASY
 */
public class FindTheTownJudge
{
    public int findJudge(int N, int[][] trust) {
        //записываем доверяет ли человек хоть кому-то
        boolean[] trusts = new boolean[N];
        //считаем сколько  людей доверяют этому человеку
        int[] isTrusted = new int[N];

        for(int i = 0; i< trust.length; i++){
            int[] curr = trust[i]; //[1,3]
            int trustsN = curr[0]; //1
            int isTrustedN = curr[1];//3
            trusts[trustsN-1] = true;//0-true
            isTrusted[isTrustedN-1]++;//
        }

        for(int i = 0; i< N; i++){
            if(!trusts[i] && (isTrusted[i]==N-1)){
                return i+1;
            }
        }
        return -1;
    }
}
