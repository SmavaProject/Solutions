package problems.easy;

public class CanPlaceFlowers {
    /***
     * # 605. Can Place Flowers - EASY
     * https://leetcode.com/problems/can-place-flowers/
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n==0){
            return true;
        }
        for(int i = 0; i<flowerbed.length; i++){
            if(flowerbed[i] == 0 && (i==0 || flowerbed[i-1] ==0) &&(i==flowerbed.length-1 || flowerbed[i+1] ==0)){
                flowerbed[i]=1;
                n--;
                if(n==0){
                    return true; //<--- return here, not at the top of the loop
                }
            }
        }
        return false;
    }
}
