package problems.easy;

public class FirstBadVersion {
    /***
     * #278. First Bad Version
     * https://leetcode.com/problems/first-bad-version/
     */
    public int firstBadVersion(int n) {
        int min = 1;
        int max = n;

        while(min<max){
            int midd = (max - min )/2 + min;

            if(Api.isBadVersion(midd)){
                if(!Api.isBadVersion(midd-1)){
                    return midd;
                }
                max = midd-1;
            }else{
                min = midd+1;
            }
        }

        return min;
    }



    private static class Api{
        static boolean isBadVersion(int version){
            return true;
        }
    }
}
