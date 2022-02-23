package problems.medium;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    /***
     * #200. Number of Islands - Medium
     * https://leetcode.com/problems/number-of-islands/
     */
    public int numIslands(char[][] grid) {
        int numOfIslands = 0;
        if(grid.length == 0 || grid[0].length == 0){
            return numOfIslands;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i< grid.length; i++){
            for (int j = 0; j< grid[0].length; j++){
                if(visited[i][j]){
                    continue;
                }
                if(grid[i][j]=='0'){
                    visited[i][j] = true;
                    continue;
                }
                if(grid[i][j]=='1'){
                    visited[i][j] = true;
                    numOfIslands++;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[] {i, j});
                    while(!queue.isEmpty()){
                        int[] cell = queue.poll();
                        if(check(cell[0], cell[1]-1, visited, grid)){
                            queue.add(new int[] {cell[0], cell[1]-1});
                        }
                        if(check(cell[0]-1, cell[1], visited, grid)){
                            queue.add(new int[] {cell[0]-1, cell[1]});
                        }
                        if(check(cell[0], cell[1]+1, visited, grid)){
                            queue.add(new int[] {cell[0], cell[1]+1});
                        }
                        if(check(cell[0]+1, cell[1], visited, grid)){
                            queue.add(new int[] {cell[0]+1, cell[1]});
                        }
                    }
                }
            }
        }

        return numOfIslands;
    }

    public boolean check(int i, int j, boolean[][] visited, char[][] grid){
        if( i>=0 && i<visited.length && j>=0 && j<visited[0].length && !visited[i][j] &&grid[i][j]=='1'){ //<- check for '1' before adding
            visited[i][j] = true; //<--- IMPORTANT!! mark visited BEFORE adding to the queue, otherwise the runtime is much longer
            return true;
        }
        return false;
    }
}
