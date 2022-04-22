package problems.easy;

import java.util.ArrayList;

public class DesignHashMap {
    /***
     * #706. Design HashMap
     * https://leetcode.com/problems/design-hashmap/
     *
     */
    class MyHashMap {
        int modulo = 769;
        Bucket[] buckets;

        public MyHashMap() {
            this.buckets = new Bucket[this.modulo];
            for (int i = 0; i< this.buckets.length; i++){
                this.buckets[i] = new Bucket(); // <<<------------------
            }
        }

        public void put(int key, int value) {
            int index = key % this.modulo;
            this.buckets[index].put(key, value);
        }

        public int get(int key) {
            int index = key % this.modulo;
            return this.buckets[index].getKey(key);
        }

        public void remove(int key) {
            int index = key % this.modulo;
            this.buckets[index].removeKey(key);
        }

        private class Bucket{
            private ArrayList<int[]> list;
            public Bucket(){
                this.list = new ArrayList<>();
            }

            public int getKey(int key) {
                for(int i = 0; i<list.size(); i++){
                    int[] currentPair = list.get(i);
                    if(currentPair[0]==key){
                        return currentPair[1];
                    }
                }
                return -1;
            }
            public void removeKey(int key) {
                for(int i = 0; i<list.size(); i++){
                    int[] currentPair = list.get(i);
                    if(currentPair[0]==key){
                        list.remove(i);
                    }
                }
            }

            public void put(int key, int value) {
                boolean replaced = false;
                for(int i = 0; i<list.size(); i++){
                    int[] currentPair = list.get(i);
                    if(currentPair[0]==key){
                        currentPair[1] = value;
                        replaced = true;
                        break;
                    }
                }
                if(!replaced){
                    list.add(new int[] {key, value});
                }
            }

        }
    }
}
