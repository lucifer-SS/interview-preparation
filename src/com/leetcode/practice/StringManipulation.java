package com.leetcode.practice;

import java.io.IOException;
import java.util.Arrays;

class CharNode {
    public String character;
    public CharNode next;
}

public class StringManipulation {

    public static void main(String args[]) throws IOException {
        String filePath = "/a/b/c/d/e/r/";
        String[] pathParts = filePath.split("/");

        Arrays.stream(pathParts).forEach(part -> System.out.println(part));
        
    }

    public static CharNode compress(CharNode stringStart) {
        // Loose the nodes till b;
        if (stringStart == null) {
            return stringStart;
        }

        CharNode temp = stringStart;
        CharNode c = new CharNode();

        return null;
    }
}
