package problems.easy;

public class FindSmallestLetterGreaterThanTarget {
    /***
     * #744. Find Smallest Letter Greater Than Target - EASY
     * https://leetcode.com/problems/find-smallest-letter-greater-than-target/
     *
     */

    public char nextGreatestLetter(char[] letters, char target) {
        if(letters.length==0){
            return target;
        }
        int start = 0;
        int end = letters.length;
        int smallestGreaterThanTarget = 0;
        while(start<end){
            int midd = start + (end-start)/2;
            /*
             * если target меньше середины (letters[midd]) то мы предполагаем что smallestGreaterThanTarget равен середине,
             * даже если есть еще меньшие значения для smallestGreaterThanTarget, это ОК, при следующих итерациях
             * smallestGreaterThanTarget будет уменьшаться
             */
            if(target<letters[midd]){
                end = midd;
                smallestGreaterThanTarget = midd;
                //если target больше середины(letters[midd]) то есть вариант что он вообще очень большой
                // => мы не обновляем smallestGreaterThanTarget
            }else{
                start = midd+1;
            }
        }
        return letters[smallestGreaterThanTarget];
    }
}
