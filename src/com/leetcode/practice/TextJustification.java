package com.leetcode.practice;

import java.util.LinkedList;
import java.util.List;

public class TextJustification {

    private static final String SPACE = " ";

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> lines = getLines(words, maxWidth);
        List<String> lastLine = lines.remove(lines.size() - 1);
        List<String> result = new LinkedList<>();
        for (List<String> line : lines) {
            result.add(this.justifyLine(line, maxWidth));
        }

        result.add(this.leftJustifyLine(lastLine, maxWidth));
        return result;
    }

    private List<List<String>> getLines(String[] words, int maxWidth) {
        List<List<String>> lines = new LinkedList<>();
        List<String> line = new LinkedList<>();
        lines.add(line);
        int lineWidth = 0;
        for (String word : words) {
            if (lineWidth + word.length() + line.size() <= maxWidth) {
                line.add(word);
                lineWidth += word.length();
            } else {
                line = new LinkedList<>();
                lines.add(line);
                line.add(word);
                lineWidth = word.length();
            }
        }

        return lines;
    }

    private String justifyLine(List<String> line, int maxWidth) {
        int wordsLength = line.stream().mapToInt(String::length).sum();
        int requiredSpaces = maxWidth - wordsLength;

        if (line.size() == 1) {
            return this.leftJustifyLine(line, maxWidth);
        }

        int equalSpaces = requiredSpaces / (line.size() - 1);
        int extraSpaces = requiredSpaces % (line.size() - 1);

        StringBuilder stringLine = new StringBuilder(line.remove(0));
        for (String word : line) {
            int spaceCounter = 0;
            while (spaceCounter < equalSpaces) {
                stringLine.append(SPACE);
                spaceCounter++;
            }
            if (extraSpaces > 0) {
                stringLine.append(SPACE);
                extraSpaces--;
            }

            stringLine.append(word);
        }

        return stringLine.toString();
    }

    private String leftJustifyLine(List<String> line, int maxWidth) {
        StringBuilder stringLine = new StringBuilder(line.remove(0));
        for (String word : line) {
            stringLine.append(SPACE).append(word);
        }

        while (stringLine.length() < maxWidth) {
            stringLine.append(SPACE);
        }

        return stringLine.toString();
    }
}
