package problems.medium;

public class RotateImage {
    /***
     * #48. Rotate Image
     * https://leetcode.com/problems/rotate-image/
     * Solution:
     * https://leetcode.com/problems/rotate-image/solution/
     */

    public void rotate(int[][] matrix) {
        int len = matrix.length;

        //transpose matrix
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) { //i+1 to avoid flipping number with itself
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        //reflect matrix
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][len - j - 1];
                matrix[i][len - j - 1] = tmp;
            }
        }

    }
}
