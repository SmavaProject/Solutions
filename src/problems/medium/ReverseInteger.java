package problems.medium;

public class ReverseInteger {
    /***
     * #7. Reverse Integer
     * https://leetcode.com/problems/reverse-integer/
     */

    public int reverse(int x) {
        String xStr = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        for(int i= xStr.length()-1; i>=0 ; i--){
            char c = xStr.charAt(i);
            if(i==xStr.length()-1 && c == 0){
                continue;
            }else if(i==0 && c =='-'){
                sb.insert(0, c);
            }else{
                sb.append(c);
            }
        }
        int res = 0;
        try{
            res = Integer.valueOf(sb.toString());
        }catch(Exception e){
            return 0;
        }
        return res;
    }
}
