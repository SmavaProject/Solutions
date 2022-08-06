package problems.medium;

public class StringCompression {
    /***
     * #443. String Compression
     * https://leetcode.com/problems/string-compression/
     */

    public int compress(char[] chars) {
        if(chars.length == 1) return 1;


        Character prev = chars[0];
        int count = 0; // start with 0 (!!!)
        int traverseIndex = 0; // index to traverse - start with 0 (!!!)
        int placeIndex = 0; //index where to place compressed values

        while(traverseIndex < chars.length && placeIndex < chars.length){
            prev = chars[traverseIndex];
            count = 0;
            while(traverseIndex < chars.length && prev == chars[traverseIndex]){
                traverseIndex++;
                count++;
            }
            chars[placeIndex++] = prev;
            if(count!=1){
                for(char c : Integer.toString(count).toCharArray()){ //<<<----- !!!!!!!!!
                    chars[placeIndex++] = c;
                }

            }
        }



        return placeIndex;

    }

}
