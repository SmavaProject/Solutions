package problems.easy;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    /**
     * 412. Fizz Buzz
     * https://leetcode.com/problems/fizz-buzz/
     */

    public List<String> fizzBuzz(int n) {
        ArrayList<String> result = new ArrayList<>();
        for(int i = 1; i<=n; i++){
            if(i%5 == 0 && i%3 == 0){
                result.add("FizzBuzz");
            }else if(i%3 == 0){
                result.add("Fizz");
            }else if(i%5 == 0){
                result.add("Buzz");
            }else{
                result.add(String.valueOf(i));
            }
        }
        return result;
    }
}