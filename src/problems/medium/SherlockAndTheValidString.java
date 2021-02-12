package problems.medium;

import java.util.HashMap;

/***
 * https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
 */
public class SherlockAndTheValidString
{
    public static String isValid(String s) {
        if(s.length()<1){
            return "NO";
        }
        //calculate all characters in the string: a-2, b-2, c-3, g-2, e -2
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i< s.length(); i++){
            Character c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        //посчитай количество уникальных количеств букв: 2-4, 3-1
        //number-occurence
        HashMap<Integer, Integer> results = new HashMap<>();
        for (Integer c : map.values()){
            results.put(c, results.getOrDefault(c, 0)+1);
        }
        //если все количества букв одинаковы
        if(results.size()==1){
            return "YES";
        }
        //если есть 3 и больще значения количеств букв - это NO
        if(results.size()>2){
            return "NO";
        }


        int key = -1;
        int val = -1;
        for (Integer c : results.keySet()){
            //это первый элемент, поэтому просто присвоим значение для key-val
            if (key == -1){
                key = c;
                val = results.get(c);
                //это второй элемент в HashMap, поэтому сейчас будем на самом деле сравнимать
            }else{
                //если хотя бы одно key==1 and value ==1 - то мы сможем сделат valid string
                //то есть если одна любая буква в String была 1 раз - ее можно убрать и сделат valid string
                if((key==1 && val ==1) ||(c==1 && results.get(c)==1)){
                    return "YES";
                }

                //еще один пособ сделать valid string - отнять от большего ключа ОДНО лишнее значение
                // ключи должны отличатся не более чем на 1, а value быть 2
                int diff = Math.abs(c-key);
                if(diff!=1){
                    return "NO";
                }
                //значение одного (от большего ключа) value должно быть 1
                if(key>c){
                    if(val!=1){
                        return "NO";
                    }
                }else{
                    if(results.get(c)!=1){
                        return "NO";
                    }
                }
            }
        }
        return "YES";

    }
}
