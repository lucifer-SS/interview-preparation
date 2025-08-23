package com.leetcode.practice;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class MaximizeSweetness {

    /*
    Given an array of sweets with space separated integers, return the maximum sweetness
    one can pick up given if you picked sweet at 'i' you can't pick 'i-1' or 'i+1' indexes.
     */

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        List<Integer> inputList = new ArrayList<>();
        int i = Integer.parseInt(sc.nextLine());
        System.out.println(i);
        String s = sc.nextLine();
        System.out.println(s);
        sc.close();

//        String inputInteger = "";
//        for (int i=0; i<inputStr.length(); i++) {
//            Character c = inputStr.charAt(i);
//            if (c != ' ') {
//                inputInteger = inputInteger + c.toString();
//            }
//
//            if (c == ' ') {
//                if (!inputInteger.isEmpty()) {
//                    inputList.add(Integer.parseInt(inputInteger));
//                    inputInteger = "";
//                }
//            }
//        }
//        if (!inputInteger.isEmpty()) {
//            inputList.add(Integer.parseInt(inputInteger));
//        }

         // System.out.write(maxSweetness(0, inputList).toString().getBytes(StandardCharsets.UTF_8));
    }

    private static Map<Integer, Integer> indexSweetnessMap = new HashMap<Integer, Integer>();

    public static Integer maxSweetness(Integer index, List<Integer> inputList) {
        if (index >= inputList.size()) {
            return 0;
        }

        if (indexSweetnessMap.containsKey(index)) {
            return indexSweetnessMap.get(index);
        }

        Integer pick = inputList.get(index);
        Integer sw2 = maxSweetness(index + 1, inputList);
        Integer sw1 = pick + maxSweetness(index + 2, inputList);

        indexSweetnessMap.put(index, Math.max(sw1, sw2));
        return indexSweetnessMap.get(index);
    }
}

