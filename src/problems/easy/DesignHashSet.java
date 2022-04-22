package problems.easy;

import java.util.ArrayList;

public class DesignHashSet {
    /***
     * #705. Design HashSet
     * https://leetcode.com/problems/design-hashset/
     * Можно было не делать Bucket а оставить ArrayList[] list = new ArrayList[modulo];
     */
    class MyHashSet {
        private Bucket[] list;
        private int modulo = 769;

        public MyHashSet() {
            this.list = new Bucket[modulo];
            for (int i = 0; i< this.list.length; i++){
                this.list[i] = new Bucket(); // <<<------------------
            }
        }

        public void add(int key) {
            int index = key % modulo;
            ArrayList<Integer> keyList = this.list[index].keyList;
            if(!keyList.contains((Integer) key)){
                keyList.add(key);
            }
        }

        public void remove(int key) {
            int index = key % modulo;
            ArrayList<Integer> keyList = this.list[index].keyList;
            if(keyList.contains((Integer) key)){
                keyList.remove((Integer)key);
            }
        }

        public boolean contains(int key) {
            int index = key % modulo;
            ArrayList<Integer> keyList = this.list[index].keyList;
            return keyList.contains((Integer) key);
        }

        private class Bucket{
            public ArrayList<Integer> keyList;
            public Bucket(){
                this.keyList = new ArrayList<>();
            }

        }
    }
}
