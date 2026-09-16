package arrays_hashing.p0705_design_hashset;

import java.util.LinkedList;

// Runtime: O(1), Memory: O(size + n)
class MyHashSet {
    private LinkedList<Integer>[] buckets;
    private final int size = 1000;

    public MyHashSet() {
        buckets = new LinkedList[size];
    }

    private int hash(int key) {
        return key % size;
    }

    public void add(int key) {
        int idx = hash(key);

        if (buckets[idx] == null) buckets[idx] = new LinkedList<>();
        if (!buckets[idx].contains(key)) buckets[idx].add(key);
    }

    public void remove(int key) {
        int idx = hash(key);

        if (buckets[idx] != null) buckets[idx].remove((Integer) key);
    }

    public boolean contains(int key) {
        int idx = hash(key);

        return buckets[idx] != null && buckets[idx].contains(key);
    }
}
