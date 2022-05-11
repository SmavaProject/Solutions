package problems.easy;

public class LengthOfLastWord {
    /**
     * #58. Length of Last Word
     * https://leetcode.com/problems/length-of-last-word/
     */
    //Approach 1
    public int lengthOfLastWord(String s) {
        //String trimmed = s.trim();
        String[] splitted = s.split(" ");
        return splitted[splitted.length-1].length();
    }

    //Approach2: better runtime
    public int lengthOfLastWord1(String s) {
        int len = 0;
        int i = s.length()-1;
        boolean wordFound = false;

        while(i>=0){
            char currChar = s.charAt(i);
            if(currChar == ' ' && wordFound){
                break;
            }
            if(currChar != ' '){
                wordFound = true;
                len++;
                i--;
            }else{
                i--;
            }
        }
        return len;
    }
}
