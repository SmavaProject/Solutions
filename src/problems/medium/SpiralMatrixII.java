package problems.medium;

public class SpiralMatrixII {
    /**
     * #59. Spiral Matrix II - medium
     * https://leetcode.com/problems/spiral-matrix-ii/
     */

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int n2 = n*n;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int direction = 0;
        int row = 0;
        int col = 0;
        for(int i = 1; i<= n2; i++){
            matrix[row][col]=i;
            //check whether the cell is valid BEFORE changin row/col.
            //Otherwise even if you change the direction the cell will be not valid
            if(validCell(matrix, row + directions[direction][0], col+ directions[direction][1])){
                row = row + directions[direction][0];
                col = col + directions[direction][1];
            }else{
                //change direction
                direction = direction <3 ? direction +1 : 0;

                row += directions[direction][0];
                col += directions[direction][1];
            }
        }
        return matrix;
    }

    public boolean validCell(int[][] matrix, int row, int col){
        return row>=0 && row<matrix.length &&
                col>=0 && col<matrix[0].length && matrix[row][col]==0;
    }
}
