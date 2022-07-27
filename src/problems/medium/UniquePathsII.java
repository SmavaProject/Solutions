package problems.medium;

public class UniquePathsII {
    /***
     * #63. Unique Paths II
     * https://leetcode.com/problems/unique-paths-ii/
     */

    //[[0,0,0],[0,1,0],[0,0,0],[0,0,0]]
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] pathes = new int[obstacleGrid.length][obstacleGrid[0].length];
        int indexX = 0;
        while(indexX< obstacleGrid.length && obstacleGrid[indexX][0]!=1){
            pathes[indexX][0] = 1;
            indexX++;
        }
        int indexY = 0;
        while(indexY < obstacleGrid[0].length && obstacleGrid[0][indexY]!=1){
            pathes[0][indexY] = 1;
            indexY++;
        }
        for(int i = 1; i< obstacleGrid.length; i++){
            for(int j = 1; j<obstacleGrid[0].length; j++){
                if(isValidMove(i, j, obstacleGrid)){
                    pathes[i][j] = pathes[i][j-1] + pathes[i-1][j];
                }
            }
        }

        return pathes[pathes.length-1][pathes[0].length-1];
    }

    private boolean isValidMove(int x, int y, int[][] obs){
        if(x<0 || y<0 || x>= obs.length || y>= obs[0].length) return false;
        if(obs[x][y] == 1) return false;
        return true;
    }
}
