package problems;

import java.util.Arrays;
import java.util.Comparator;

public class Comp
{
    public static int[][] toTry(int[][] abc){

        Comparator<int[]> comp = new Comparator<int[]>() {
            @Override
            public int compare (int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        };

        Arrays.sort(abc, comp);
        return abc;
    }
}
