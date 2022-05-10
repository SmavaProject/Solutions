package problems.medium;

public class UniquePaths {
    /***
     * #62. Unique Paths
     * https://leetcode.com/problems/unique-paths/
     */
    public int uniquePaths(int m, int n) {

        int[][] grid = new int[m][n];
        //first row is always equal to one as there is only one way to go there -> -> -> etc.
        for(int i = 0; i< grid[0].length; i++){
            grid[0][i] = 1;
        }
        //first column is always equal to one as there is only one way to go there: down, down down etc.
        for(int i = 0; i< grid.length; i++){
            grid[i][0] = 1;
        }
        //every other cell can be reached from the cell above or from the cell to the left
        //thus, the number of unique paths for every cell is the sum of the pathese from these cells
        for(int i = 1; i< grid.length; i++){
            for (int j = 1; j< grid[0].length; j++){
                grid[i][j] = grid[i-1][j] + grid[i][j-1];
            }
        }
        return grid[m-1][n-1];
    }
}
