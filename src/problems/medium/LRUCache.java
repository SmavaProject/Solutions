package problems.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/***
 * https://leetcode.com/problems/lru-cache/ - MEDUIM #146
 *
 * This solution has poor runtime, probably because of the QUEUE - we need to update values in the queue and remove then. => not efficient
 *
 * Runtime: 141 ms, faster than 8.71% of Java online submissions for LRU Cache.
 * Memory Usage: 47.4 MB, less than 47.17% of Java online submissions for LRU Cache.
 *
 *
 */
public class LRUCache
{
    HashMap<Integer, Integer> map;
    Queue<Integer> leastUsed; //needs to be updated efficently (?)
    int maxCapacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>(capacity);
        this.leastUsed = new LinkedList<>();
        this.maxCapacity = capacity;
    }

    public int get(int key) {
        if(this.map.containsKey(key)){
            this.leastUsed.remove(key);
            this.leastUsed.add(key);
            return this.map.get(key);
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        //update key. no matter if it is full or empty
        if(this.map.containsKey(key)){
            this.leastUsed.remove(key);

            //add new key. Map is full => clean up first
        }else if(this.map.size()==this.maxCapacity){
            Integer index = this.leastUsed.poll();
            this.map.remove(index);
        }
        //add new key. Map has space

        this.map.put(key, value);
        this.leastUsed.add(key);

    }
}
