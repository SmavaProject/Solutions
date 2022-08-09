package problems.hard;

public class SudokuSolver {

    /***
     * #37. Sudoku Solver
     * https://leetcode.com/problems/sudoku-solver/
     */

    public void solveSudoku(char[][] board) {
        backtracking(board, 0, 0);
    }

    private boolean backtracking(char[][]board, int row, int col){
        if(col == board.length){//if we finished with the column move to the next row
            col = 0;
            row ++;
        }
        if(row == board.length){ //all rows are traversed, sudoku is solved
            return true;
        }

        //if the cell is not empty - move on to the next cell
        if(board[row][col] != '.'){
            return backtracking(board, row, col + 1);
        }
        for(char i = '1'; i <= '9'; i++) {//<<<<< ----- iterate over chars!!!
            if(canPlaceDigit(board, row, col, i)){
                board[row][col] = i;
                //put '.' back if eventually sudoku is not solved with i. and move to the next possible i
                if(backtracking(board, row, col + 1)){
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
    }

    public boolean canPlaceDigit(char[][] board, int row, int col, char digit){
        int box = row/3*3 + col/3;
        for(int k = 0; k<9; k++){
            if(board[row][k] == digit || board[k][col]==digit ||
                    board[box/3*3 + k / 3][box % 3 * 3 + k % 3] == digit){ // <<<<<------ (!!!)
                return false;
            }
        }
        return true;
    }
}
