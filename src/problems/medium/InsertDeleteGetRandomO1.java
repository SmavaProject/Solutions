package problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class InsertDeleteGetRandomO1 {
    /**
     * #380. Insert Delete GetRandom O(1) - MEDIUM
     * https://leetcode.com/problems/insert-delete-getrandom-o1/
     *
     * Главная идея задачи - все операции должны производиться в O(1) время
     * Map - обеспечивает insert, delete за O(1). Чтобы удалить значение из List за O(1)
     * мы меняем его с последним элементом и удаляем с конца
     * List+ random - обеспечивают получение index за O(1)
     */
    //<val, place in list>
    HashMap<Integer, Integer> map;
    List<Integer> values;
    Random random;

    public InsertDeleteGetRandomO1() {
        this.map = new HashMap<>();
        this.values = new ArrayList<>();
        this.random = new Random();
    }

    public boolean insert(int val) {
        if(!map.containsKey(val)){
            map.put(val, values.size());
            values.add(val);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if(map.containsKey(val)){
            //get the index of the val and swap the val with the last element in the list
            int valIndex = map.get(val);
            int tmpIndex = this.values.size()-1;
            int tmpVal = this.values.get(tmpIndex);
            //update map and list with the tmp value
            this.values.set(valIndex, tmpVal);
            this.map.put(tmpVal, valIndex);

            //remove val from both list and map
            map.remove(val);
            this.values.remove(tmpIndex);
            return true;
        }
        return false;
    }

    public int getRandom() {
        int upperBoundry = values.size();
        int randomIndex = random.nextInt(upperBoundry);
        return values.get(randomIndex);
    }

}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
