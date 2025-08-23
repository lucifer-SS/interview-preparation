package com.leetcode.practice;

import com.leetcode.lfu.CacheItem;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.stream.Collectors;

class Item {
    Integer value;
    Integer frequency;

    public Item(int value) {
        this.value = value;
        this.frequency = 0;
    }
}

public class Solution1 {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Item> keyMap = new HashMap<>();

        for (int num : nums) {
            keyMap.putIfAbsent(num, new Item(num));
            keyMap.get(num).frequency += 1;
        }

        List<Item> items = keyMap.values().stream()
                .sorted((a, b) -> {
                    if (a.frequency.equals(b.frequency)) {
                        return a.value.compareTo(b.value);
                    } else {
                        return b.frequency.compareTo(a.frequency);
                    }
                })
                .collect(Collectors.toList());

        return items
                .subList(0, Math.min(k, items.size()))
                .stream()
                .map(item -> item.value)
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private static String SPACE = " ";
    private static String EMPTY = "";

    public static void main(String args[]) throws IOException, NoSuchAlgorithmException{
        List<Integer> listSample = new LinkedList<Integer>();
        Queue<Integer> sampleQueue = new LinkedList<Integer>();
        Collections.sort(listSample, (a, b) -> {
            return a.compareTo(b);
        });

        TreeMap<Integer, Integer> sample = new TreeMap<Integer, Integer>((a, b) -> {
            return a.compareTo(b);
        });

        HashMap<Integer, CacheItem> map = new HashMap<>();

        CacheItem item = new CacheItem(1, 1);
        map.put(item.getKey(), item);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a,b) -> a <= b ? 1 : -1);
        for (int i=0; i<k; i++) {
            maxHeap.add(nums[i]);
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(maxHeap.peek());

        for (int i=k; i<nums.length; i++) {
            maxHeap.remove(nums[i-k]);
            maxHeap.add(nums[i]);
            result.add(maxHeap.peek());
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static String hashUrl(String url) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(url.getBytes(StandardCharsets.UTF_8));

        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }

        System.out.println("Hash Output: " + sb.toString());

        // Take first 6 bytes (48 bits) and encode to Base62
        long value = 0;
        for (int i = 0; i < 6; i++) {
            value = (value << 8) | (hash[i] & 0xFF);
        }
        return Long.toString(value);
    }
}
