package com.leetcode.practice;

import java.util.LinkedHashMap;

class LRUCache {

    private final LinkedHashMap<Integer, Integer> lruStorage;
    private final Integer capacity;

    public LRUCache(int capacity) {
        this.lruStorage = new LinkedHashMap<>();
        this.capacity = capacity;

    }

    public int get(int key) {
        Integer value = this.lruStorage.remove(key);
        if (value != null) {
            this.lruStorage.put(key, value);
            return value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        this.lruStorage.remove(key);

        if (this.lruStorage.size() >= capacity) {
            Integer firstKey = this.lruStorage.keySet().iterator().next();
            this.lruStorage.remove(firstKey);
        }

        this.lruStorage.put(key, value);
    }
}
