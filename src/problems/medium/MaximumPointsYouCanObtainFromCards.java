package problems.medium;

import java.util.Arrays;

public class MaximumPointsYouCanObtainFromCards {
    /**
     * 1423. Maximum Points You Can Obtain from Cards
     * https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
     *
     * Dynamic programming
     * Prefix sum
     */


    /// Dynamic programming
    public int maxScore(int[] cardPoints, int k) {
        if(cardPoints.length == k) {
            //return Arrays.stream(cardPoints).boxed().collect(Collectors.summingInt(Integer::intValue)); //<<< ----- !!!!!!
            return Arrays.stream(cardPoints).boxed().mapToInt(Integer::intValue).sum(); //<<< ----- !!!!!!
        }
        int len = cardPoints.length;
        int[] forward = new int[k+1]; //элемент 0 оставим ==0, чтобы мы могли "не брать" ни одного элемента в начале
        forward[1]=cardPoints[0];
        int[] backward = new int[k+1];//элемент 0 оставим ==0, чтобы мы могли "не брать" ни одного элемента в конце
        backward[1]=cardPoints[len-1];
        for(int i = 2; i<=k; i++){
            forward[i] = forward[i-1] + cardPoints[i-1];
        }
        /*
        * backward - на самом деле мы кладем значения все равно от 0 -> k (a не от k->0), просто считаем в обратном порядке
        cardPoints: [1,2,3,4,5,6,1]
        k: 3
        len: 7
        forward: [0,1,3,6]
        backward: [0,1,7,12]
        */
        for(int i = 2; i<=k; i++){
            backward[i] = backward[i-1] + cardPoints[len-i];
        }

        int max = 0;

        for(int i = 0; i<=k; i++){
            int currScore = forward[i] + backward[k-i];
            max = Math.max(max, currScore);
        }

        return max;
    }

    /**
     * Recursion. Works but time limit exceeded. Optimizations -?
     */
    public int maxScore1(int[] cardPoints, int k) {

        return recursion(cardPoints, k, cardPoints.length-1 ,0);
    }

    public int recursion(int[] cardPoints, int k, int right, int left){
        if(k==0){
            return 0;
        }

        int currMax = Math.max(recursion(cardPoints, k-1, right-1,left) + cardPoints[right] , recursion(cardPoints, k-1, right,left+1) +cardPoints[left]);

        return currMax;
    }
}
