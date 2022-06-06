package problems.medium;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumKnightMoves {
    /***
     * #1197. Minimum Knight Moves
     * https://leetcode.com/problems/minimum-knight-moves/
     */
    public int minKnightMoves(int x, int y) {
        if(x == 0 && y == 0)return 0;
        int[][] directions = {
                {2, 1},
                {2, -1},
                {1, 2},
                {-1, 2},
                {-2, 1},
                {-2, -1},
                {-1, -2},
                {1, -2}
        };
        Queue<int[]> queue = new LinkedList<>();
        int [] startCell = new int[]{0, 0};
        queue.offer(startCell);
        int steps = 1;
        int numOfOptionsOnCurrentStep = 0;

        //use array instead of HashSet to avoid time limit exceed
        boolean[][] visited = new boolean[605][605];

        while(!queue.isEmpty()){
            numOfOptionsOnCurrentStep = queue.size();
            for(int i = 0; i< numOfOptionsOnCurrentStep; i++){
                int[] curr = queue.poll();
                for(int[] dir: directions){
                    int cell1 = curr[0]+dir[0];
                    int cell2 = curr[1]+dir[1];
                    if(cell1==x && cell2==y){
                        return steps;
                    }else{
                        if(!visited[cell1+ 302][cell2+ 302]){
                            queue.offer(new int[]{cell1, cell2});
                            visited[cell1 + 302][cell2 + 302] = true;
                        }
                    }
                }
            }
            steps++;
        }
        return steps;
    }
}

