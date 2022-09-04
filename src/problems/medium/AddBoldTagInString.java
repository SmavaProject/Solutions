package problems.medium;

public class AddBoldTagInString {
    /***
     * #616. Add Bold Tag in String
     * https://leetcode.com/problems/add-bold-tag-in-string/
     */

    //brute force
    public String addBoldTag(String s, String[] words) {
        boolean[] bold = new boolean[s.length()];
        for(int i = 0; i< words.length; i++){
            String word = words[i];
            if(s.contains(word)){
                int start = 0;
                int wordIndex = 0;
                int sIndex = 0;
                while(start<s.length()){
                    while(sIndex<s.length() && wordIndex<word.length() && s.charAt(sIndex) == word.charAt(wordIndex)){
                        wordIndex++;
                        sIndex++;
                    }
                    if(wordIndex==word.length()){//we found a match
                        for(int j = start; j< word.length() + start; j++){
                            bold[j] = true;
                        }
                        //reset word index and search for further matches of this word
                        wordIndex = 0;
                        //break;
                    }else{
                        wordIndex = 0;
                        start++;
                        sIndex = start;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(index< s.length()){
            if(bold[index]){
                sb.append("<b>");
                while(index< s.length()&& bold[index]){
                    sb.append(s.charAt(index));
                    index++;
                }
                sb.append("</b>");
            }else{
                sb.append(s.charAt(index));
                index++;
            }
        }

        return sb.toString();
    }
}
