package problems.hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SlidingPuzzle {
    /***
     * #773. Sliding Puzzle
     * https://leetcode.com/problems/sliding-puzzle/
     * BFS
     */

    public int slidingPuzzle(int[][] board) {
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int stRow = 0; //start row. search for 0 on the board and start from there
        int stCol = 0;

        for(int i = 0; i< 2; i++){
            for(int j = 0; j< 3; j++){
                if(board[i][j]==0){
                    stRow = i;
                    stCol = j;
                    break;
                }
            }
        }
        String targetState = Arrays.deepToString(new int[][]{{1,2,3}, {4,5,0}}); //<<<-----

        Queue<State> queue = new LinkedList<>();
        State initialState = new State(board, stRow, stCol, 0);
        queue.add(initialState);

        Set<String> visited = new HashSet<>();
        visited.add(initialState.boardStr);

        while(!queue.isEmpty()){
            State currState = queue.poll();
            if(currState.boardStr.equals(targetState)){ //we found the target
                return currState.movesDone;
            }

            for(int[] dir: directions){
                int newRow = dir[0] + currState.row;
                int newCol = dir[1] + currState.col;

                if(newRow < 0 || newRow >=2 || newCol <0 || newCol >= 3 ){
                    //(Math.abs(newRow - currState.row) + Math.abs(newCol - currState.col) != 1))
                    continue;
                }

                int[][] newBoard = new int[2][3]; //create new board
                int index = 0;
                for(int[] boardRow : currState.currBoard){//copy the board
                    newBoard[index++] = boardRow.clone();
                }
                //assign new values to the board
                newBoard[currState.row][currState.col] = newBoard[newRow][newCol];
                newBoard[newRow][newCol] = 0;

                State newState = new State(newBoard, newRow, newCol, currState.movesDone + 1);
                if(visited.contains(newState.boardStr)){
                    continue;
                }
                queue.add(newState);
                visited.add(newState.boardStr);

            }
        }

        return -1;
    }

    class State{
        int[][] currBoard;
        int row;
        int col;
        int movesDone;
        String boardStr;
        State(int[][] b, int r, int c, int m){
            currBoard = b;
            row = r;
            col = c;
            movesDone = m;
            boardStr = Arrays.deepToString(b); //<<-----
        }
    }
}
