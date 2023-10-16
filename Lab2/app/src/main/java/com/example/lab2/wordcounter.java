package com.example.lab2;

public class WordCounter {
    public static int getCharsCount(String phrase) {
        return phrase.length();
    }

    public static int getWordsCount(String phrase) {
        // Split the input text into words using spaces, commas, and dots
        String[] words = phrase.split("[\\s,\\.]");
        int count = 0;
        for (String word : words) {
            if (!word.isEmpty()) {
                count++;
            }
        }
        return count;
    }
}
