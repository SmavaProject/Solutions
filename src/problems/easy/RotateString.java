package problems.easy;

public class RotateString {
    /***
     * 796. Rotate String
     * https://leetcode.com/problems/rotate-string/
     */

    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        boolean isMatchFound = false;
        for(int i = 0; i< s.length(); i++){
            if(isMatchFound) break;
            int indexS = i;
            int indexG = 0;

            char charS = s.charAt(indexS);
            char charG = goal.charAt(indexG);

            while(charS==charG && indexG<goal.length()){
                if(indexS < s.length() -1){
                    indexS++;
                }else{
                    indexS = 0;
                }
                indexG++;
                if(indexG == goal.length()){
                    isMatchFound = true;
                    break;
                }
                charS = s.charAt(indexS); //<<----- обновляем char после увеличения индексов, не вверху
                charG = goal.charAt(indexG); //<<-----
            }

        }
        return isMatchFound;
    }
}
