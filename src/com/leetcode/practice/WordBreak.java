package com.leetcode.practice;

import java.util.*;

public class WordBreak {

    public static void main(String args[]) {
        String s = "catskicatca";
        String a[] = {"cats","cat","dog","ski"};
        List<String> wordDict = Arrays.asList(a);

        WordBreak wb = new WordBreak();
        System.out.println("Result: " + wb.wordBreak(s, wordDict));
    }

    private class TrieNode {
        boolean isWord;
        TrieNode[] letters = new TrieNode[26];
    }

    private HashMap<String, Boolean> resultMap = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        TrieNode trieDict = this.convertWordDictToTrie(wordDict);
        return wordBreak(s, trieDict);
    }

    public boolean wordBreak(String s, TrieNode trieDictRoot) {
        if (resultMap.get(s) != null) {
            return resultMap.get(s);
        }
        if (s.isEmpty()) {
            resultMap.put(s, true);
            return true;
        }

        TrieNode node = trieDictRoot;

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (node.letters[c - 'a'] == null) {
                break;
            }

            node = node.letters[c - 'a'];

            if (node.isWord) {
                if (wordBreak(s.substring(i + 1), trieDictRoot)) {
                    resultMap.put(s, true);
                    return true;
                }
            }
        }

        resultMap.put(s, false);
        return false;
    }

    public TrieNode convertWordDictToTrie(List<String> wordDict) {
        TrieNode root = new TrieNode();

        for (String word : wordDict) {
            TrieNode node = root;
            for (int i=0; i< word.length(); i++) {
                char c = word.charAt(i);
                if (node.letters[c - 'a'] == null) {
                    node.letters[c - 'a'] = new TrieNode();
                }

                node = node.letters[c - 'a'];
                if (i == word.length() - 1) {
                    node.isWord = true;
                }
            }
        }

        return root;
    }
}
