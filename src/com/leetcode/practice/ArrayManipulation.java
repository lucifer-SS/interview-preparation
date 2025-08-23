package com.leetcode.practice;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class ArrayManipulation {

    public static void main(String args[]) throws IOException {
        int[] nums = {1, 2, 3};
        System.out.println(minimumOperations(nums));
    }
    public static int minimumOperations(int[] nums) {

        List<Integer> list = new LinkedList<Integer>();
        Arrays.stream(nums).forEach(list::add);
        HashSet<Integer> uniqueNumbers = list.stream()
                .filter(i -> i != 0)
                .collect(Collectors.toCollection(HashSet::new));

        Boolean fe = Boolean.FALSE;
        list.sort(Comparator.naturalOrder());
        list.stream().forEach(l -> System.out.print(l + ","));
        list.sort(Comparator.reverseOrder());
        System.out.println();
        list.stream().forEach(l -> System.out.print(l + ","));
        System.out.println();

        // for (int i=0; i<nums.length; i++) {
        //     if (nums[i] != 0) {
        //         uniqueNumbers.add(nums[i]);
        //     }
        // }
        return uniqueNumbers.size();
    }
}
