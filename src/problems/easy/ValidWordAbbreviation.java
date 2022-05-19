package problems.easy;

public class ValidWordAbbreviation {
    /***
     * #408. Valid Word Abbreviation
     * https://leetcode.com/problems/valid-word-abbreviation/
     *
     */
    public boolean validWordAbbreviation(String word, String abbr) {
        int indexAbbr = 0;
        int indexWord = 0;
        StringBuilder sb = new StringBuilder();

        while(indexAbbr<abbr.length()){
            if(indexWord>word.length()-1)return false; //when abbr is longer than word
            char c = abbr.charAt(indexAbbr);
            if(Character.isLetter(c)){
                if(word.charAt(indexWord) == c){
                    indexAbbr++;
                    indexWord++;
                }else{
                    return false;
                }
            }else{//c is a digit
                do{
                    sb.append(abbr.charAt(indexAbbr));
                    indexAbbr++;
                }while(indexAbbr<abbr.length() && Character.isDigit(abbr.charAt(indexAbbr)));

                if(sb.charAt(0) == '0') return false;
                Integer shiftInt = Integer.valueOf(sb.toString());
                for (int i = 0; i< shiftInt; i++){
                    indexWord++;
                }
                if(indexWord>word.length())return false; //indexWord overflow. case: "a" ,"2"

                sb.setLength(0);
            }

        }
        if(indexWord<word.length())return false; //when we did not finish traversing the word.case: "hi", "1"
        return true;

    }
}
