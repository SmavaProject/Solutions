package problems.medium;

public class OneEditDistance {
    /***
     * #161. One Edit Distance
     * https://leetcode.com/problems/one-edit-distance/
     */
    public boolean isOneEditDistance(String s, String t) {
        if(s.equals(t)) return false;
        if(Math.abs(s.length() - t.length())>1) return false;

        int indexS = 0;
        int indexT = 0;
        boolean wasEdited = false;

        while(indexS<s.length()&& indexT<t.length()){
            char sChar = s.charAt(indexS);
            char tChar = t.charAt(indexT);

            if(sChar != tChar && wasEdited){
                return false;
            }else if(sChar != tChar){
                if(s.length()==t.length()){
                    indexS++;
                    indexT++;
                }else if(s.length()<t.length()){
                    indexT++;
                }else{
                    indexS++;
                }
                wasEdited = true;
            }else{
                indexS++;
                indexT++;
            }



        }
        return true;

    }
}