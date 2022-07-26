package problems.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class BullsAndCows {
    /***
     * #299. Bulls and Cows
     * https://leetcode.com/problems/bulls-and-cows/
     */

    //Very slow solution
    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> secretDigits = new HashMap<>();
        HashMap<Character, Integer> guessDigits = new HashMap<>();

        int bulls = 0;
        for(int i = 0; i< secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i)){
                bulls++;
            }else{
                Integer sCount = secretDigits.getOrDefault(secret.charAt(i), 0);
                secretDigits.put(secret.charAt(i), sCount + 1);

                Integer gCount = guessDigits.getOrDefault(guess.charAt(i), 0);
                guessDigits.put(guess.charAt(i), gCount + 1);
            }

        }

        Set<Character> intersection = new HashSet<Character>(secretDigits.keySet());
        intersection.retainAll(guessDigits.keySet());

        int cows = 0;

        for (Character c: intersection){
            int cCount = Math.min(secretDigits.get(c), guessDigits.get(c));
            cows+= cCount;
        }


        return bulls + "A" + cows + "B";

    }
}
