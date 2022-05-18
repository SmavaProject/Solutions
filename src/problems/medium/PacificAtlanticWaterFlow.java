package problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticWaterFlow {
    /***
     * #417.Pacific Atlantic Water Flow
     * https://leetcode.com/problems/pacific-atlantic-water-flow/
     * /

    /***
     * Главная идея для ускорения алгоритма заключается в том, чтобы не искать для каждой клетки
     * можно ли из нее достичь океана, а пройтись по всей матрице и пометить каждую ее клетку достижима ли ОНА(!) ИЗ океана.
     * Для этого помечаем все границы как достижимые и начинаем ОТ них помечать все клетки с такой же либо большей высотой как достижимые.
     *
     * Совет: лучше задекларировать rowNumber, colNumber и использовать их чтобы не путаться в [heights.length][heights[0].length]
     */
    private int[][] directions = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
    };
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        //0 - unknown, 1 can, -1 can not
        int[][] canReachPacific = new int[heights.length][heights[0].length];
        int[][] canReachAtlantic = new int[heights.length][heights[0].length];

        Queue<int[]> pacific = new LinkedList<>();
        Queue<int[]> atlantic = new LinkedList<>();

        for(int r = 0;r< heights.length; r++){
            canReachPacific[r][0] = 1; //every column 0
            pacific.add(new int[]{r, 0});
            canReachAtlantic[r][heights[0].length-1] = 1;//last column for every row
            atlantic.add(new int[]{r, heights[0].length-1});
        }
        for(int c = 0; c< heights[0].length; c++){
            canReachPacific[0][c] =1 ; // row 0 for every column
            pacific.add(new int[]{0, c});
            canReachAtlantic[heights.length -1][c] =1;//last row for every column
            atlantic.add(new int[]{heights.length-1, c});
        }

        bfs(canReachPacific, heights, pacific);
        bfs(canReachAtlantic, heights, atlantic);

        List<List<Integer>> result = new ArrayList<>();
        for(int r = 0;r< heights.length; r++){
            for(int c = 0; c< heights[0].length; c++){
                if(canReachPacific[r][c]==1 && canReachAtlantic[r][c]==1){
                    ArrayList<Integer> coordinates = new ArrayList<>(Arrays.asList(r, c));
                    result.add(coordinates);
                }
            }
        }
        return result;
    }

    private void bfs(int[][] canReachOcean, int[][] heights, Queue<int[]> queue){
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            visited[cell[0]][cell[1]] = true;
            int currHeight = heights[cell[0]][cell[1]];
            for(int[] direction : directions){
                int[] neighbour = new int[]{cell[0] + direction[0], cell[1] + direction[1] };
                if(withinBoundries(neighbour, heights, currHeight) && !visited[neighbour[0]][neighbour[1]] ){
                    canReachOcean[neighbour[0]][neighbour[1]] = 1;
                    queue.add(new int[]{neighbour[0],neighbour[1]});
                }
            }
        }
    }

    private boolean withinBoundries(int[] neighbour, int[][] heights, int currHeight){
        if(neighbour[0]<0 || neighbour[1]<0 || neighbour[0]>=heights.length || neighbour[1]>=heights[0].length){
            return false;
        }
        if(heights[neighbour[0]][neighbour[1]]< currHeight){ //also check the height
            return false;
        }
        return true;
    }
}

