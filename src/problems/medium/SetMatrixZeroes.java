package problems.medium;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {
    /**
     * #73. Set Matrix Zeroes
     * https://leetcode.com/problems/set-matrix-zeroes/
     */
    public void setZeroes(int[][] matrix) {
        Set<Integer> indexI = new HashSet<>();
        Set<Integer> indexJ = new HashSet<>();
        for(int i = 0; i< matrix.length; i++){
            for (int j = 0; j< matrix[0].length; j++){
                if(matrix[i][j]==0){
                    if(!indexI.contains(i))
                        indexI.add(i);
                    if(!indexJ.contains(j))
                        indexJ.add(j);
                }
            }
        }
        for(Integer i: indexI){
            for(int j = 0; j< matrix[0].length; j++)
                matrix[i][j]=0;
        }
        for(Integer j: indexJ){
            for(int i = 0; i< matrix.length; i++)
                matrix[i][j]=0;
        }

    }
}
