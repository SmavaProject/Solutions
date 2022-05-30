package problems.hard;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    /***
     * #68.Text Justification
     * https://leetcode.com/problems/text-justification/
     *
     */
    class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            ArrayList<String> result = new ArrayList<String>();
            int right = 0; //index
            int currLen = 0;
            int numOfWords = 0;

            while (right < words.length) {
                //add space " "(before word)
                while (right < words.length && words[right].length() + currLen + numOfWords <= maxWidth) {
                    currLen += words[right].length();
                    numOfWords++;
                    right++;
                }

                //рефакторить (!!!)
                int numExtraSpaces = 0;
                int numSpacesBetweenWords = numOfWords != 1 ? (maxWidth - currLen) / (numOfWords - 1) : 1;
                if (numSpacesBetweenWords * (numOfWords - 1) + currLen != maxWidth) {
                    numExtraSpaces = maxWidth - numSpacesBetweenWords * (numOfWords - 1) - currLen;
                }

                String str = appendStr(words, maxWidth, numOfWords, numSpacesBetweenWords, numExtraSpaces, right);

                result.add(str);
                currLen = 0;
                numOfWords = 0;


            }


            return result;
        }

        private String appendStr(String[] words, int maxWidth, int numOfWords, int numSpacesBetweenWords, int numExtraSpaces, int right) {
            StringBuilder sb = new StringBuilder();
            //add words to the left part of the string
            if (numOfWords == 1 || right == words.length) { //dont add extra spaces
                while (numOfWords > 0) {
                    sb.append(words[right - numOfWords]);
                    if (numOfWords > 1) sb.append(" ");
                    numOfWords--;
                }
                while (sb.length() < maxWidth) { //add missing " "
                    sb.append(" ");
                }

            //distribute words evenly by adding extra spaces
            } else {
                while (numOfWords > 1) {
                    sb.append(words[right - numOfWords]);
                    for (int j = 0; j < numSpacesBetweenWords; j++) {
                        sb.append(" ");
                    }
                    if (numExtraSpaces > 0) {
                        sb.append(" ");
                        numExtraSpaces--;
                    }
                    numOfWords--;
                }
                sb.append(words[right - 1]);
            }
            return sb.toString();
        }
    }
}
