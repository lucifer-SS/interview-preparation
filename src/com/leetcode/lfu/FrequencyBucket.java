package com.leetcode.lfu;

import java.util.LinkedHashSet;

public class FrequencyBucket {

    private Integer frequency;
    private LinkedHashSet<Integer> keys;

    private FrequencyBucket left;
    private FrequencyBucket right;

    public FrequencyBucket(Integer frequency) {
        this.frequency = frequency;
        this.keys = new LinkedHashSet<Integer>();

        left = null;
        right = null;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public LinkedHashSet<Integer> getKeys() {
        return keys;
    }

    public FrequencyBucket getLeft() {
        return left;
    }

    public void setLeft(FrequencyBucket left) {
        this.left = left;
    }

    public FrequencyBucket getRight() {
        return right;
    }

    public void setRight(FrequencyBucket right) {
        this.right = right;
    }

}
