package problems.medium;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {
    /**
     * #271. Encode and Decode Strings
     * https://leetcode.com/problems/encode-and-decode-strings/
     */
    //use ' * ' as splitter. Double original * if there are any
    //удвоим * если они есть в оригинальных String чтобы не split в ненужном месте
    //{"abc", "def"}    =>  "abc * def * "
    //{'abc', '*def'}   =>  "abc * **def * "
    //{'abc**', 'def'}  =>  "abc**** * def * "
    //НЕ РАБОТАЕТ с *, только с # .     может потому что * is a reserverd char in regex <<< ????

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s: strs)
            sb.append(s.replace("#", "##")).append(" # ");

        return sb.toString();

    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        ArrayList<String> res = new ArrayList();
        String[] array = s.split(" # ", -1);

        for (int i=0; i<array.length-1; ++i)
            res.add(array[i].replace("##", "#"));

        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));