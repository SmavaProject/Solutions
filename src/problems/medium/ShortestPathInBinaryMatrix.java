package problems.medium;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    /***
     * #1091. Shortest Path in Binary Matrix
     * https://leetcode.com/problems/shortest-path-in-binary-matrix/
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        //edge cases:
        if(grid.length==1 && grid[0].length == 1 && grid[0][0]==0)return 1;
        if(grid[0][0]!=0) return -1;

        int[][] directions = new int[][]{
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0},
                {1, 1},
                {-1, -1},
                {-1, 1},
                {1, -1}
        };
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        //i, j, level
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{0, 0, 1});//-?
        int minPath = Integer.MAX_VALUE;

        while(!q.isEmpty()){
            int[] cell = q.poll();
            for (int[] dir : directions){
                if(isValid(grid, visited, dir[0] + cell[0], dir[1] + cell[1])){
                    if((dir[0] + cell[0])==grid.length-1 && ( dir[1] + cell[1])==grid[0].length-1){
                        minPath = Math.min(cell[2]+1, minPath);
                    }else{
                        visited[dir[0] + cell[0]][dir[1] + cell[1]] = true;
                        q.add(new int[]{
                                dir[0] + cell[0],
                                dir[1] + cell[1],
                                cell[2] + 1
                        });
                    }
                }
            }
        }

        return minPath == Integer.MAX_VALUE? -1 :minPath;
    }

    public boolean isValid(int[][] grid, boolean[][] visited, int i, int j){
        return i>= 0 && j>=0 && i<grid.length && j<grid[0].length && grid[i][j]==0 && (!visited[i][j]);
    }

}
