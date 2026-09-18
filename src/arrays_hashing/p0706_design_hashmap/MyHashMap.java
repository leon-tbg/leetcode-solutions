package arrays_hashing.p0706_design_hashmap;

import java.util.LinkedList;

class MyHashMap {
    private static class Entry {
        int key, value;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Runtime: Best: O(1) Worst: O(n), Memory: O(size + n) | for all methods
    private LinkedList<Entry>[] buckets;
    private final int size = 1000;

    public MyHashMap() {
        buckets = new LinkedList[size];
    }

    private int hash(int key) {
        return key % size;
    }

    public void put(int key, int value) {
        int idx = hash(key);

        if (buckets[idx] == null) buckets[idx] = new LinkedList<>();

        for (Entry e : buckets[idx]) {
            if (e.key == key) {
                e.value = value;
                return;
            }
        }

        buckets[idx].add(new Entry(key, value));
    }

    public int get(int key) {
        int idx = hash(key);

        if (buckets[idx] == null) return -1;

        for (Entry e : buckets[idx]) {
            if (e.key == key) return e.value;
        }

        return -1;
    }

    public void remove(int key) {
        int idx = hash(key);

        if (buckets[idx] == null) return;

        for (Entry e : buckets[idx]) {
            if (e.key == key) {
                buckets[idx].remove(e);
                return;
            }
        }
    }
}
