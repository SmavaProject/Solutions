package problems.easy;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    /***
     * #733. Flood Fill
     * https://leetcode.com/problems/flood-fill/
     */

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int startColor = image[sr][sc]; //<<------------------------ remember the starting color
        Queue<int[]> cells = new LinkedList<>();
        cells.add(new int[]{sr, sc});
        int[][] directions = new int[][]{
                new int[]{1, 0},
                new int[]{0, 1},
                new int[]{-1, 0},
                new int[]{0, -1},
        };
        while(!cells.isEmpty()){
            int[] cell = cells.poll();
            image[cell[0]][cell[1]] = newColor;
            for(int[] direction : directions){
                int[] neighb = new int[]{cell[0] + direction[0], cell[1] + direction[1]};
                if(isValid(neighb, image, newColor, startColor)){
                    cells.add(neighb);
                }
            }
        }
        return image;
    }

    private boolean isValid(int[] neighb, int[][] image, int newColor, int startColor){
        if(neighb[0]>image.length-1 || neighb[1]>image[0].length-1
                ||neighb[0]<0 || neighb[1]<0 )return false;
        if(image[neighb[0]][neighb[1]] == newColor)return false;
        if(image[neighb[0]][neighb[1]] != startColor)return false;
        return true;
    }
}
