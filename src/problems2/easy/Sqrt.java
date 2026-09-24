package problems2.easy;

public class Sqrt {
    //https://leetcode.com/problems/sqrtx/description/

    public int mySqrt(int x) {
        long min = 0;
        long max = Integer.MAX_VALUE;
        long midd = max/2;

        while (min<=max){
            midd = (min+max)/2;
            if (midd * midd == x) return (int) midd;

            if(midd * midd < x){
                min = midd+1;
            }else{
                max = midd -1;
            }
        }

        return (int) max;

    }

}
