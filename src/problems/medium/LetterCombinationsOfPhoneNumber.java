package problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 *  https://leetcode.com/problems/letter-combinations-of-a-phone-number/ #17 MEDIUM
 */
public class LetterCombinationsOfPhoneNumber
{
    Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};


    public List<String> letterCombinations(String digits) {
        List<String> output = new ArrayList<String>();
        if (digits.length()==0){ // check empty input
            return output;
        }
        recursion(digits, "", 0, output);
        return output;
    }
    /***
     * Base case:
     * If the string that we are working on reached the length of the input => we already collected
     * the combination. Stop processing and add it to the result.
     * Other case:
     * Go through all digits. Loop through every value of the
     */
    public void recursion(String digits, String currentString, int digitIndex, List<String> output){
        //base case
        if (currentString.length() == digits.length()){
            output.add(currentString);
            return;
        }

        Character currentDigit = digits.charAt(digitIndex);
        String letters = this.phoneMap.get(currentDigit);
        //for every letter in letters -  this.phoneMap.get(currentDigit).length()
        //go to the next digit and append its values
        for (int i = 0; i< letters.length(); i++){
            String currentLetter = String.valueOf(letters.charAt(i));
            recursion(digits, currentString + currentLetter, digitIndex + 1, output);
        }
    }
}
