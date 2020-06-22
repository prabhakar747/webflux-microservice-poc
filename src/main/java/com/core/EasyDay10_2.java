package com.core;

import java.util.*;

public class EasyDay10_2 {

    public static void main(String[] args) {
        String paragraph = "a, a, a, a, b, b, b, c, c";
        paragraph = paragraph.replaceAll("\\.", "");
        paragraph = paragraph.replaceAll("\\;", "");
        paragraph = paragraph.replaceAll("\\,", "");
        paragraph = paragraph.replaceAll("\\'", "");
        paragraph = paragraph.replaceAll("\\?", "");
        paragraph = paragraph.replaceAll("\\!", "");
        paragraph = paragraph.toLowerCase();
        String[] banned = new String[]{"a"};
        System.out.println("Most Common Word: " + mostCommonWord(paragraph, banned));
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        String mostCommonWord = null;
        String[] words = paragraph.split(" ");
        Set<String> bannedSet= convertArrayToSet(banned);
        Map<String, Integer> map = new HashMap<String, Integer>();
        int count = 1;
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                count = map.get(words[i]).intValue();
                count++;
                map.put(words[i], count);
            } else {
                map.put(words[i], count);
            }
            if(bannedSet.contains(words[i])){
                count = 1;
                map.put(words[i], count);
            }
        }
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostCommonWord = entry.getKey();
            }
        }
        return mostCommonWord;
    }

    public static <T> Set<T> convertArrayToSet(T array[])
    {

        Set<T> banset = new HashSet();
        for (T word: array) banset.add(word);
        return banset;
    }
}