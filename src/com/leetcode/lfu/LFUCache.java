package com.leetcode.lfu;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LFUCache {

    private Integer capacity;
    private Map<Integer, CacheItem> storage;
    private FrequencyBucket head;
    private FrequencyBucket tail;


    public LFUCache(int capacity) {
        this.capacity = capacity;
        storage = new HashMap<Integer, CacheItem>();
        head = new FrequencyBucket(0);
        tail = new FrequencyBucket(Integer.MAX_VALUE);
        head.setRight(tail);
        tail.setLeft(head);
    }

    public int get(int key) {
        CacheItem existingItem = storage.get(key);
        if (existingItem != null) {
            hitItem(key);
            return existingItem.getValue();
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        CacheItem existingItem = storage.get(key);
        if (existingItem != null) {
            existingItem.setValue(value);
            hitItem(key);
        } else {
            CacheItem item = new CacheItem(key, value);

            if (storage.size() >= capacity) {
                evictItem();
            }

            FrequencyBucket existingBucket = this.head.getRight();
            if (existingBucket.getFrequency() == 1) {
                existingBucket.getKeys().add(key);
                item.setBucket(existingBucket);
            } else {
                FrequencyBucket bucket = new FrequencyBucket(1);
                FrequencyBucketUtils.insert(this.head, bucket, existingBucket);
                bucket.getKeys().add(key);
                item.setBucket(bucket);
            }
            storage.put(key, item);
        }
    }

    private void hitItem(int key) {
        CacheItem item = storage.get(key);
        FrequencyBucket existingBucket = item.getBucket();
        existingBucket.getKeys().remove(key);

        Integer frequency = existingBucket.getFrequency() + 1;

        FrequencyBucket right = existingBucket.getRight();

        if (right.getFrequency().equals(frequency)) {
            right.getKeys().add(key);
            item.setBucket(right);
        } else {
            FrequencyBucket bucket = new FrequencyBucket(frequency);
            FrequencyBucketUtils.insert(existingBucket, bucket, right);
            bucket.getKeys().add(key);
            item.setBucket(bucket);
        }

        if (existingBucket.getKeys().isEmpty()) {
            FrequencyBucketUtils.remove(existingBucket);
        }
    }

    private void evictItem() {
        FrequencyBucket leastFrequencyBucket = this.head.getRight();
        Iterator<Integer> iterator = leastFrequencyBucket.getKeys().iterator();
        int leastFrequentKey = iterator.next();
        iterator.remove();

        if (leastFrequencyBucket.getKeys().isEmpty()) {
            FrequencyBucketUtils.remove(leastFrequencyBucket);
        }

        storage.remove(leastFrequentKey);
    }
}
