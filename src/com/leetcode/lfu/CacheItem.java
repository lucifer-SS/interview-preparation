package com.leetcode.lfu;

public class CacheItem {
    private Integer key;
    private Integer value;
    private FrequencyBucket bucket;

    public CacheItem(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public FrequencyBucket getBucket() {
        return bucket;
    }

    public void setBucket(FrequencyBucket bucket) {
        this.bucket = bucket;
    }
}
