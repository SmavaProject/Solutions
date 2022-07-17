package problems.medium;

public class DesignTicTacToe {
    /***
     * #348. Design Tic-Tac-Toe
     * https://leetcode.com/problems/design-tic-tac-toe/
     */
    class TicTacToe {

        int[][] game;
        public TicTacToe(int n) {
            game = new int[n][n];
        }

        public int move(int row, int col, int player) {
            game[row][col] = player;
            if(checkWinner(row, col,player)) return player;
            return 0;
        }

        private boolean checkWinner(int row, int col, int player){

            if(checkRow(row,player)) return true;

            if(checkCol(col,player)) return true;

            if(checkDiagonal(row, col,player)) return true;

            return false;
        }

        private boolean checkRow(int row, int player){
            for(int i = 0; i< game[0].length; i++){
                if(game[row][i]!=player) return false;
            }
            return true;
        }

        private boolean checkCol(int col, int player){
            for(int i = 0; i< game.length; i++){
                if(game[i][col]!=player) return false;
            }
            return true;
        }

        private boolean checkDiagonal(int row, int col, int player){
            if(row!=col && (row!=game.length - col -1)) return false; // <<<------ row/col is not on a diagonal
            boolean firstDiag = true;
            for(int i = 0; i< game.length; i++){
                if(game[i][i]!=player) firstDiag = false;
            }
            boolean secondDiag = true;
            for(int i = 0; i< game.length; i++){
                if(game[i][game.length - i -1]!=player) secondDiag = false;
            }

            return (firstDiag || secondDiag);
        }
    }
}
