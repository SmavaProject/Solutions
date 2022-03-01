package problems.medium;

import java.util.ArrayList;

public class IntervalListIntersections {

/***
 * # 986. Interval List Intersections - MEDIUM
 * https://leetcode.com/problems/interval-list-intersections/
 * Solution:
 * https://www.educative.io/courses/grokking-the-coding-interview/JExVVqRAN9D
 *
 */

public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
    if(firstList.length == 0 || secondList.length == 0){
        return new int[0][0];
    }
    ArrayList<int[]> result = new ArrayList<>();
    int pointer1 = 0;
    int pointer2 = 0;
    while(pointer1<firstList.length && pointer2< secondList.length){
        int[] l1 = firstList[pointer1];
        int[] l2 = secondList[pointer2];
        //l1 начинается и заканчивается раньше l2
        //l1 поглощает l2
        if((l1[0]<=l2[0]&&l1[1]>=l2[1])||(l1[0]<=l2[0]&&l1[1]>=l2[0])){
            int[] intersect = new int[]{Math.max(l1[0],l2[0]), Math.min(l1[1],l2[1])};
            result.add(intersect);
        }
        //l2 начинается и заканчивается раньше l1
        //l2 поглощает l1
        else if((l2[0]<=l1[0]&&l2[1]>=l1[1])||(l2[0]<=l1[0]&&l2[1]>=l1[0])){
            int[] intersect = new int[]{Math.max(l1[0],l2[0]), Math.min(l1[1],l2[1])};
            result.add(intersect);
        }
        //compare END(!!!) of interval and remove the smallest
        if(l1[1]<=l2[1]){
            pointer1++;
        }else{
            pointer2++;
        }
    }
    return result.toArray(new int[result.size()][]); //<<<<--------
}
}

/***
 * Есть еще проще решение:
 * Каждый раз считать int[] intersect = new int[]{Math.max(l1[0],l2[0]), Math.min(l1[1],l2[1])};
 * Если intersect[0]<=intersect[1]  - то  l1 пересекает l2 ->>>> result.add(intersect);
 */
