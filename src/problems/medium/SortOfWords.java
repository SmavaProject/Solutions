package problems.medium;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/***
 * Sort List of Words
 *
 * Given a list of words and an ordering, return true or false if the list is in the correct alphabetical order
 *
 * Example 1:
 * words: ["cc", "cb", "ca", "bc", "ab"]
 * ordering = ["c", "b", "a"]
 * Output: True
 *
 * Example 2:
 * Words: ["ca", "cb", "cc", "bc", "ab"]
 * ordering = ["c", "b", "a"]
 * output = False
 *
 * Example 3:
 * Words: ["cc", "cb", "ca", "bccc", "bca"]
 * ordering = ["c", "b", "a"]
 * output = True
 *
 * Example 4:
 * Words = ["cc", "cb", "ca", "bca", "bccc"]
 * Ordering = ["c", "b", "a"]
 * Output = False
 *
 * Example 5:
 * Words = ["cc", "cb", "bca", "bcac"]
 * ordering = ["c", "b", "a"]
 * output = True
 */

//it has never been tested on a real input
public class SortOfWords {

    public boolean sortedListOfWords(ArrayList<String> words, ArrayList<Character> ordering){
        //IMPORTANT: assign index to every letter in ordering
        Map<Character, Integer> order = new HashMap<>();
        for (int i = 0; i< ordering.size(); i++){
            order.put(ordering.get(i), i);
        }

        String prevWord = words.get(0);
        for(String word: words){
            for(int i = 0; i< word.length(); i++){

                // if previous word is shorter  - just go to the  next word
                if(prevWord.length()<= i){
                    break; // or continue?
                }
                Character currChar = word.charAt(i);
                Character prevWordChar = prevWord.charAt(i);

                Integer currCharPosition = order.get(currChar);
                Integer prevWordCharPosition = order.get(prevWordChar);

                if(prevWordCharPosition> currCharPosition){
                    return false;
                }
                prevWord = word;
            }
        }

        return true;
    }
}
