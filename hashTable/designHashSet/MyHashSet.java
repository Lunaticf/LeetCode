package leetCode.hashTable.designHashSet;

import java.util.Arrays;

class MyHashSet {

    private boolean[] data;

    /** Initialize your data structure here. */
    public MyHashSet() {
        data = new boolean[1000000];
    }

    public void add(int key) {
        data[key] = true;
    }

    public void remove(int key) {
        data[key] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return data[key];
    }
}

// 稍微高效一点的做法
class MyHashSet1 {

    private boolean[] data;

    /** Initialize your data structure here. */
    public MyHashSet1() {
        data = new boolean[100];
    }

    public void add(int key) {
        if (key >= data.length) {
            extend(key);
        }
        data[key] = true;
    }

    private void extend(int key) {
        data = Arrays.copyOf(data, key + 1);
    }

    public void remove(int key) {
        if (key >= data.length) {
            extend(key);
        }
        data[key] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if (key >= data.length) {
            return false;
        }
        return data[key];
    }
}
