package problems.medium;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIsland {
    /***
     * #695. Max Area of Island - medium
     * https://leetcode.com/problems/max-area-of-island/
     */
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxArea = 0;
        int[][] directions = new int[][]{
                new int[] {0, 1},
                new int[] {1, 0},
                new int[] {0, -1},
                new int[] {-1, 0}
        };

        for(int i = 0; i< grid.length; i++){
            for(int j = 0; j< grid[0].length; j++){
                if(!visited[i][j]){
                    visited[i][j] = true;
                    //we found an island
                    if(grid[i][j] ==1){
                        Queue<int[]> queue = new LinkedList<>();
                        queue.add(new int[]{i, j});
                        int area = 0;
                        while(!queue.isEmpty()){
                            int[] cell = queue.poll();
                            area++;
                            for (int[] direction : directions){
                                int[] neighb = new int[]{cell[0]+direction[0], cell[1]+direction[1]};
                                if(isValidNeighb(neighb, visited, grid)){
                                    visited[neighb[0]][neighb[1]] = true;
                                    queue.add(neighb);
                                }
                            }
                        }
                        maxArea = Math.max(area, maxArea);
                    }
                }
            }
        }
        return maxArea;
    }
    private boolean isValidNeighb(int[] neighb, boolean[][] visited,int [][] grid){
        if(neighb[0]<0 || neighb[1]<0 || neighb[0]>grid.length-1 || neighb[1]>grid[0].length-1)return false;
        if(visited[neighb[0]][neighb[1]])return false;
        if(grid[neighb[0]][neighb[1]]==0){
            visited[neighb[0]][neighb[1]] = true;// mark it as visited here to make the alg faster
            return false;
        }
        return true;
    }
}