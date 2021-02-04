package problems;

import java.util.Iterator;
import java.util.List;

public class ValidateSubsequence
{
    /***
     * Algoexpert problem Validate Subsequence. EASY
     */
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        // Write your code here.
        if(array.size()< sequence.size()){
            return false;
        }
        Integer[] array1 = array.toArray(new Integer[0]);
        boolean foundFlag = false;
        int indexOfPreviousFound = -1;
        for (Integer currInt : sequence){
            if (indexOfPreviousFound == array1.length-1){
                return false;
            }
            for (int i = indexOfPreviousFound + 1; i < array1.length; i++){
                foundFlag = false;
                if(currInt == array1[i]){
                    indexOfPreviousFound = i;
                    array1[i] = Integer.MIN_VALUE;
                    foundFlag = true;
                    break;
                }
                if(i == array1.length-1){
                    return false;
                }
            }
        }
        if (foundFlag){
            return true;
        }
        return false;
    }
}
