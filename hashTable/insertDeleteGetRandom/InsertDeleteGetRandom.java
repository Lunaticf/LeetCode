package leetCode.hashTable.insertDeleteGetRandom;

import java.util.*;

public class InsertDeleteGetRandom {

    /**
     * Your RandomizedSet object will be instantiated and called as such:
     * RandomizedSet obj = new RandomizedSet();
     * boolean param_1 = obj.insert(val);
     * boolean param_2 = obj.remove(val);
     * int param_3 = obj.getRandom();
     */

    class RandomizedSet {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();


        /** Initialize your data structure here. */
        public RandomizedSet() {

        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (hashMap.containsKey(val)) {
                return false;
            } else {
                // 如果没有 插入
                hashMap.put(val, list.size());
                list.add(val);
                return true;
            }
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (hashMap.containsKey(val)) {
                int i = hashMap.get(val);

                // 如果不是最后一个元素
                if (i < list.size() - 1) {
                    int lastOne = list.get(list.size() - 1);
                    list.set(i, lastOne);
                    hashMap.put(lastOne, i);
                }

                list.remove(list.size() - 1);
                hashMap.remove(val);

                return true;
            }
            return false;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int num = random.nextInt(list.size());
            return list.get(num);
        }
    }

}
