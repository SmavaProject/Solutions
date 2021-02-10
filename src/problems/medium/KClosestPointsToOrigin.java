package problems.medium;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.PriorityQueue;

/***
 * https://leetcode.com/problems/k-closest-points-to-origin/ #973 MEDIUM
 */
public class KClosestPointsToOrigin
{
    public int[][] kClosest(int[][] points, int K) {

        //Pair<>: distance-indexOfPoint
        PriorityQueue<Pair<Integer, Integer>> pk = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>(){
            @Override
            public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2){
                return p1.getKey() - p2.getKey(); // min heap
            }
        });

        //add all points to min heap, track their index in points[][]
        for(int i = 0; i< points.length; i++){
            int[] point = points[i];
            Integer distance = point[0]*point[0] + point[1]*point[1];
            pk.add(new Pair(distance, i));
        }

        int[][] result = new int[K][2];
        //get top K elements from pk, find their values in points and add to the result
        while (K>0){
            result[K-1] = points[pk.poll().getValue()];
            K--;
        }

        return result;
    }
}
