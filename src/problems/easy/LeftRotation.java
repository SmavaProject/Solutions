package problems.easy;

/***
 * https://www.hackerrank.com/challenges/ctci-array-left-rotation EASY
 * Arrays
 */
public class LeftRotation
{
    static int[] rotLeft(int[] a, int d) {
        int[] tmp = new int[d];
        for (int i = 0; i< d; i++){
            tmp[i] = a[i];
        }
        int pointer = d;
        int tmpPointer = 0;
        for (int i = 0; i< a.length; i++){
            if(i<a.length-d){
                a[i] = a[pointer];
                pointer++;
            }else{
                a[i] = tmp[tmpPointer];
                tmpPointer++;
            }
        }
        return a;
    }
}
