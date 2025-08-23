package com.leetcode.practice;

//import java.io.IOException;
//import java.util.*;
//import java.util.stream.Collectors;
//
public class GoogleInterview {
//    public class Node {
//        int layer;
//        int id; //index
//        int cost;
//        int[] incomingEdges;
//    }
//
//    // https://docs.google.com/document/d/11relVvSI21VBJJLkJBJDhNthmpB6DOwwhp1jvpVeeeE/edit
//
//    public class Solution {
//
//        public int[] minCost(Node[][] nodes) {
//            if (nodes == null) {
//                return new int[0];
//            }
//
//            for (int i=0; i<nodes.length; i++){
//                for(int j=0; j<nodes[i].length; j++) {
//                    if (nodes[i][j] == null) {
//                        return new int[0]; //or Exception
//                    }
//                }
//            }
//
//            int[] prevCost = new int[nodes[1].length];;
//
//            Arrays.stream(nodes[1]).forEach(n -> prevCost[n.id] = n.cost);
//
//            int[] currentCost = new int[nodes[1].length];
//
//            for (int i=1; i<nodes.length; i++) {
//                for (int j=0; i<nodes[i].length; j++) {
//                    Node node = nodes[i][j];
//                    int minCost = Integer.MAX_VALUE;
//                    for (int k=0; k<node.incomingEdges.length; k++) {
//                        int cost = prevCost[k] + node.incomingEdges[k] + node.cost;
//                        minCost = Math.min(minCost, cost);
//                    }
//                    currentCost[j] = minCost;
//                }
//                prevCost = currentCost;
//            }
//
//            return prevCost;
//        }
//    }
}
