package problems.medium;

import java.util.ArrayList;
import java.util.List;

public class ShortestDistanceToTargetColor {
    /***
     * #1182. Shortest Distance to Target Color
     * https://leetcode.com/problems/shortest-distance-to-target-color/
     */

    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        List<Integer> result = new ArrayList<>();
        ArrayList<Integer> color1 = new ArrayList<>();
        ArrayList<Integer> color2 = new ArrayList<>();
        ArrayList<Integer> color3 = new ArrayList<>();

        for(int i = 0; i< colors.length; i++){
            if(colors[i] == 1){
                color1.add(i);
            }else if(colors[i] == 2){
                color2.add(i);
            }else if(colors[i] == 3){
                color3.add(i);
            }
        }

        for(int[] query: queries){
            int targetColor = query[1];
            int distance = -1;
            if(targetColor == 1){
                distance = findDistance(query[0], color1);
            }else if(targetColor ==2 ){
                distance = findDistance(query[0], color2);
            }else if(targetColor ==3 ){
                distance = findDistance(query[0], color3);
            }

            result.add(distance);
        }

        return result;
    }

    //Используем Binary search, но очень по харерски если значение closest positions "приблизительное"
    //В идеале стоит переписать с Collections.binarySearch и интерпретацией результата
    //find closest integer in positions
    private int findDistance( int targetPosition, ArrayList<Integer> positions){
        if(positions.size() ==0) return -1;
        if(positions.size() == 1) return Math.abs(positions.get(0) - targetPosition);

        int start = 0;
        int end = positions.size()-1;
        int midd = (end + start)/2;

        while(start<=end){
            midd = (end + start)/2;
            if(positions.get(midd) == targetPosition){ //target color is the same as given index
                return 0;
            }else{
                if(positions.get(midd) > targetPosition){
                    end = midd -1;
                }else{
                    start = midd + 1;
                }
            }
        }
        //midd is the closest point

        if(midd == 0){
            int l = Math.abs(positions.get(midd) - targetPosition);
            int r = Math.abs(positions.get(midd+1) - targetPosition);
            return Math.min(l, r);
        }else if(midd == positions.size()-1){
            int l = Math.abs(positions.get(midd) - targetPosition);
            int r = Math.abs(positions.get(midd-1) - targetPosition);
            return Math.min(l, r);
        } else{
            int l = Math.abs(positions.get(midd-1) - targetPosition);
            int r = Math.abs(positions.get(midd+1) - targetPosition);
            int m = Math.abs(positions.get(midd) - targetPosition);
            return Math.min(l, Math.min(r, m));
        }
    }
}