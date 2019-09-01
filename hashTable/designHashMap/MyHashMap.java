package leetCode.hashTable.designHashMap;

import java.util.Arrays;

class MyHashMap {

    private int[] data;

    /** Initialize your data structure here. */
    public MyHashMap() {
        data = new int[100];
        Arrays.fill(data, 0, 100, -1);
    }

    private void extend(int key) {
        int rawLen = data.length;
        data = Arrays.copyOf(data, key + 1);
        Arrays.fill(data, rawLen, data.length, -1);
    }


    /** value will always be non-negative. */
    public void put(int key, int value) {
        if (key >= data.length) {
            extend(key);
        }
        data[key] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if (key < data.length) {
            return data[key];
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        if (key < data.length) {
            data[key] = -1;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

class MyHashMap1 {

    private int[] data = new int[1000001];

    /** Initialize your data structure here. */
    public MyHashMap1() {
        Arrays.fill(data, -1);
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        data[key] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return data[key];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        data[key] = -1;
    }
}

class MyHashMap2 {
    class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Node[] data;

    /** Initialize your data structure here. */
    public MyHashMap2() {
        data = new Node[10000];
    }

    private int getIdx(int key) {
        return Integer.hashCode(key) % data.length;
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int idx = getIdx(key);
        Node n = data[idx];
        while (n != null && n.key != key) {
            n = n.next;
        }

        if (n != null) {
            n.value = value;
        } else {
            data[idx] = new Node(key, value, data[idx]);
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int idx = getIdx(key);
        if (data[idx] != null) {
            Node n = data[idx];
            while (n != null) {
                if (n.key == key) {
                    return n.value;
                }
                n = n.next;
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int idx = getIdx(key);
        if (data[idx] != null) {
            // 如果可能存在

            // 如果就是第一个节点
            if (data[idx].key == key) {
                data[idx] = data[idx].next;
            } else {
                Node prev = null;
                Node n = data[idx];

                // 找到链上对应的节点
                while (n != null) {
                    if (n.key == key) {
                        prev.next = n.next;
                    }
                    prev = n;
                    n = n.next;
                }
            }

        }
    }
}
