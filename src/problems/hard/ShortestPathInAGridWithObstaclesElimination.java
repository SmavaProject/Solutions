package problems.hard;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInAGridWithObstaclesElimination {

    /**
     * 1293. Shortest Path in a Grid with Obstacles Elimination
     * https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/
     *
     *
     * Задача практически классический BFS, в котором нужно найти ближайшее расстояние до какой-то цели
     * Но нам нужно хранить еще 1 piece of information: количество оставшихся k
     * Один из способов это сделать - это добавить еще одно dimension в матрицу visited
     * По определению BFS, первое решение которое найдет lower right corner и есть Shortest Path
     */
    public int shortestPath(int[][] grid, int k) {
        int[][] directions = new int[][]{
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
        };

        int steps = 0;

        boolean[][][] visited = new boolean[grid.length][grid[0].length][k+1]; //k+1
        visited[0][0][k] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, k}); //add first cell

        while(!queue.isEmpty()){

            for(int i = queue.size(); i>0; i--){ //these are cells at the distance `steps`
                int[] cell = queue.poll();
                int x = cell[0];
                int y = cell[1];
                int remainingK = cell[2];

                if(x == grid.length-1 && y == grid[0].length-1) return steps; //destination is found

                for(int j = 0; j< directions.length; j++){
                    int[] direction = directions[j];
                    int nX = x + direction[0];
                    int nY = y + direction[1];
                    int nK = remainingK;


                    if(!validCell(grid, nX, nY)) continue;

                    if(grid[nX][nY] == 0 && !visited[nX][nY][nK]){
                        visited[nX][nY][nK] = true;
                        queue.add(new int[]{nX, nY, nK});
                    }

                    if(grid[nX][nY] == 1 && remainingK > 0 && !visited[nX][nY][nK-1]){ //<<<<--- !!!
                        visited[nX][nY][nK-1] = true;
                        queue.add(new int[]{nX, nY, nK-1});
                    }

                }

            }
            steps++;
        }

        return -1;
    }

    private boolean validCell(int[][] grid, int x, int y){
        return x>=0 && x< grid.length && y >= 0 && y < grid[0].length;
    }
}