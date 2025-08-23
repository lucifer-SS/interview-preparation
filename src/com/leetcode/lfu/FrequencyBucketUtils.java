package com.leetcode.lfu;

public class FrequencyBucketUtils {

    public static void insert(FrequencyBucket leftBucket, FrequencyBucket bucket, FrequencyBucket rightBucket) {
        leftBucket.setRight(bucket);
        bucket.setLeft(leftBucket);
        bucket.setRight(rightBucket);
        rightBucket.setLeft(bucket);
    }

    public static void remove(FrequencyBucket bucket) {
        bucket.getLeft().setRight(bucket.getRight());
        bucket.getRight().setLeft(bucket.getLeft());
    }
}
