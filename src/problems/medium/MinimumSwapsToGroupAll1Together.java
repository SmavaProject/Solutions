package problems.medium;

public class MinimumSwapsToGroupAll1Together {
    /***
     * 1151. Minimum Swaps to Group All 1's Together
     * https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together/
     * Sliding window
     */
    /*
     * Главная идея задачи - посчитать сколько вцелом есть 1 в data, пусть это будет numOfOnes
     * А потом в каждом отдельно взятом окне размером numOfOnes посчитать сколько нехватает едениц
     * Это и есть наше минимальное количество перестановок нужное для того чтобы все 1 были вместе
     */
    public int minSwaps(int[] data) {
        int minNumOfSwaps = Integer.MAX_VALUE;
        int numOfOnes = 0;
        for(int i = 0; i< data.length; i++){
            if(data[i]==1) numOfOnes++;
        }
        int left = 0;
        int currNumOfOnes = 0;
        for(int right = 0; right < data.length; right++){
            if(data[right]==1){
                currNumOfOnes++;
            }
            //We finally reached the right size of the window. Shrink it
            if(right-left == (numOfOnes-1)){
                minNumOfSwaps = Math.min(minNumOfSwaps, numOfOnes - currNumOfOnes);
                if(data[left]==1)currNumOfOnes--;
                left++;
            }
        }
        return minNumOfSwaps == Integer.MAX_VALUE ? 0: minNumOfSwaps;
    }
}