package problems.medium;

public class ShortestWordDistanceIII {
    /***
     * #245. Shortest Word Distance III - Medium
     * https://leetcode.com/problems/shortest-word-distance-iii/
     */

    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        boolean areEqual = word1.equals(word2);
        int index1 = -1;
        int index2 = -1;
        int minDistance = Integer.MAX_VALUE;

        for(int i = 0; i< wordsDict.length; i++){
            String currentWord = wordsDict[i];

            if(currentWord.equals(word1) && !areEqual){
                index1 = i;
            }else if(currentWord.equals(word2) && !areEqual){
                index2 = i;
            }else if(currentWord.equals(word1) && areEqual){
                /*
                Если слова одинаковые, то в первый раз когда мы их встречаем мы просто задаем им индекс;
                Когда мы их встретили второй раз, нам нужно понять какой из индексов поменять чтобы расстояние было минимальным,
                поэтому мы пробуем оба варианта (tmp1 и tmp2)
                 */
                if(index1 == -1 || index2 == -1){
                    if(index1 == -1){
                        index1=i;
                    }else{
                        index2=i;
                    }

                }else{
                    int tmp1 = Math.abs(i - index2);
                    int tmp2 = Math.abs(index1 - i);

                    if(tmp1<tmp2){
                        index1 = i;
                    }else{
                        index2 = i;
                    }
                }
            }

            if(index1 != -1 && index2 != -1){
                minDistance = Math.min(minDistance, Math.abs(index1 - index2));
            }

        }
        return minDistance;
    }
}