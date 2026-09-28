package problems2.medium;

public class ValidSudoku {

    //https://leetcode.com/problems/valid-sudoku/

    public boolean isValidSudoku(char[][] board) {
        java.util.Set<Character>[] row = new java.util.HashSet[9];
        java.util.Set<Character>[] col = new java.util.HashSet[9];
        java.util.Set<Character>[] sq = new java.util.HashSet[9];

        for (int i = 0; i<9; i++){
            row[i] = new java.util.HashSet<>();
            col[i] = new java.util.HashSet<>();
            sq[i] = new java.util.HashSet<>();
        }

        for (int i = 0; i<9; i++){
            for (int j = 0; j<9; j++){
                char curr = board[i][j];
                if (curr == '.') continue;

                if (row[i].contains(curr) || col[j].contains(curr)) return false;
                row[i].add(curr);
                col[j].add(curr);

                int currSq = i/3 + j/3*3; //row, column
                if(sq[currSq].contains(curr)) return false;
                sq[currSq].add(curr);

            }
        }

        return true;
    }

}
