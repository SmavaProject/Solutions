package problems.other;

public class AverageOfSubarrayOfSizeK {
    /***
     * from here: https://www.educative.io/courses/grokking-the-coding-interview/7D5NNZWQ8Wr
     * SLIDING WINDOW
     * Task:
     * Given an array, find the average of all subarrays of ‘K’ contiguous elements in it.
     *
     */

    public static double[] findAverages(int K, int[] arr) {
        double[] result = new double[arr.length- K +1];
        double currAvg = 0;
        double currSum = 0;
        int firstElement = 0;

        //calculate the initial sum
        for (int i = 0; i< K-1; i++){
            currSum += arr[i];
        }

        for (int lastElement = K -1; lastElement< arr.length; lastElement++){
            currSum += arr[lastElement];
            currAvg = currSum/K;
            result[firstElement] = currAvg;
            currSum = currSum - arr[firstElement];
            firstElement++;
        }



        return result;
    }
}
