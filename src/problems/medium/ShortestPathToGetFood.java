package problems.medium;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathToGetFood {
    /***
     * 1730. Shortest Path to Get Food
     * https://leetcode.com/problems/shortest-path-to-get-food/
     */
    public int getFood(char[][] grid) {
        int row = -1;
        int col = -1;

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int i = 0; i< grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '*'){
                    row = i;
                    col = j;
                }
            }
        }
        int[][] directions = new int[][]{
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
        };

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        int currDist = 0;

        while(!queue.isEmpty()){
            int currNeighbours = queue.size();
            currDist++;
            for(int i = 0; i< currNeighbours; i++){
                int[] cell = queue.poll();
                for(int j = 0; j< directions.length; j++){
                    int[] newCell = new int[]{cell[0] + directions[j][0], cell[1] + directions[j][1]};
                    if(valid(newCell, grid, visited)){
                        if (grid[newCell[0]][newCell[1]] =='#'){
                            return currDist;
                        }else{
                            //add to the queue
                            queue.add(newCell);
                        }
                    }
                }
            }
        }


        return -1;

    }

    private boolean valid(int[] cell, char[][] grid, boolean[][] visited){
        int i = cell[0];
        int j = cell[1];
        if(i<0 || i>=grid.length || j<0 || j>= grid[0].length) return false;
        if(visited[i][j]) return false;
        visited[i][j] = true;

        if(grid[i][j]=='X') return false;

        return true;

    }
}