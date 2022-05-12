package problems.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    /***
     * #54. Spiral Matrix
     * https://leetcode.com/problems/spiral-matrix/
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        List<Integer> res = new ArrayList();
        int[][]directions = new int[][]{
                new int[]{0, 1},
                new int[]{1, 0},
                new int[]{0, -1},
                new int[]{-1, 0}
        };
        int index = 0; //index of matrix
        int dirIndex = 0;// index of directions array
        int numElements = matrix.length * matrix[0].length;
        int i = 0;
        int j = 0;
        while(index<numElements){
            int curr = matrix[i][j];
            visited[i][j] = true;
            res.add(curr);
            if(validMove(i + directions[dirIndex][0], j + directions[dirIndex][1], visited)){
                i = i + directions[dirIndex][0];
                j = j + directions[dirIndex][1];
                index++;
            }else{
                //change direction
                dirIndex = dirIndex<3 ? dirIndex +1 : 0;
                i = i + directions[dirIndex][0];
                j = j + directions[dirIndex][1];
                index++;
            }
        }

        return res;
    }
    private boolean validMove(int i, int j, boolean[][] visited ){
        return i>=0 && j>=0 && i< visited.length && j< visited[0].length && !visited[i][j];


    }
}
