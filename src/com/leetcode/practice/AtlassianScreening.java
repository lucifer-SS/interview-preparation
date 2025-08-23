package com.leetcode.practice;

import com.sun.source.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;

public class AtlassianScreening {

    public static void main(String[] args) {
        // sample input
        System.out.println(getIdPairsForOptimal(
                Arrays.asList(Arrays.asList(1, 3000), Arrays.asList(2, 5000), Arrays.asList(3, 7000),
                        Arrays.asList(4, 10000)),
                Arrays.asList(Arrays.asList(1, 2000), Arrays.asList(2, 9000), Arrays.asList(3, 5000)), 10000));
    }

    /*
    Karat Interview: Atlassian Screening:
    Given Entry records in a 2D Array like [["John", "820"], ["Vinita", "950"]] in minutes
    Return the name of people with all the entry time if they entered at least 3 times in 100 minutes
     */
    public static Map<String, SortedSet<Integer>> valid(String[][] records) {
        HashMap<String, TreeSet<Integer>> recordsMap = new HashMap<String, TreeSet<Integer>>();

        for (int i=0; i<records.length; i++) {
            if (!recordsMap.containsKey(records[i][1])) {
                recordsMap.put(records[i][0], new TreeSet<Integer>());
            }
            recordsMap.get(records[i][1]).add(Integer.parseInt(records[i][1]));
        }

        Map<String, SortedSet<Integer>> result = new HashMap<String, SortedSet<Integer>>();

        for (Map.Entry<String, TreeSet<Integer>> entry : recordsMap.entrySet()) {
            for (Integer time : entry.getValue()) {
                SortedSet<Integer> subset = entry.getValue().subSet(time, time + 100);
                if (subset.size() >= 3) {
                    result.put(entry.getKey(), subset);
                    break;
                }
            }
        }

        return result;
    }

    public static List<List<Integer>> getIdPairsForOptimal(List<List<Integer>> forwardList,
                                                           List<List<Integer>> backwardList, int maxDistance) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        forwardList = forwardList.stream().sorted((x1, x2) -> Integer.compare(x2.get(1), x1.get(1)))
                .collect(Collectors.toList());
        backwardList = backwardList.stream().sorted((x1, x2) -> Integer.compare(x1.get(1), x2.get(1)))
                .collect(Collectors.toList());
        int maxDist = maxDistance;
        while (true) {
            for (List<Integer> l : forwardList) {
                for (List<Integer> b : backwardList) {
                    int forward = l.get(1);
                    int backward = b.get(1);
                    int tot = (forward + backward);
                    if (tot > maxDist) {
                        break;
                    }
                    if (tot == maxDist) {
                        // print the pair of Id and optimum distance
                        result.add(Arrays.asList(l.get(0), b.get(0), maxDist));
                        break;
                    }

                }
            }
            if (result.size() > 0) {
                break;
            }
            maxDist--;
        }
        return result;
    }
}
