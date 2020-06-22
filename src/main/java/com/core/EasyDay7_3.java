package com.core;

import java.util.HashMap;
import java.util.Map;

public class EasyDay7_3 {
    public static Map<String, Integer> romanValuesMap = new HashMap<String, Integer>();

    public static Map<String, Integer> setRomanValuesMap() {
        romanValuesMap.put("I", 1);
        romanValuesMap.put("V", 5);
        romanValuesMap.put("X", 10);
        romanValuesMap.put("L", 50);
        romanValuesMap.put("C", 100);
        romanValuesMap.put("D", 500);
        romanValuesMap.put("M", 1000);
        romanValuesMap.put("IV", 4);
        romanValuesMap.put("IX", 9);
        romanValuesMap.put("XL", 40);
        romanValuesMap.put("XC", 90);
        romanValuesMap.put("CD", 400);
        romanValuesMap.put("CM", 900);
        return romanValuesMap;
    }

    public static void main(String[] args) {
        setRomanValuesMap();
        System.out.println("Result Roman to Integer: " + romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        int result = 0;
        int i = 0;
        while (i < s.length()) {
            if (i < s.length() - 1) {
                String doubleCase = s.substring(i, i + 2);
                if (romanValuesMap.containsKey("" + doubleCase)) {
                    result += romanValuesMap.get(doubleCase);
                    i += 2;
                    continue;
                }
            }
            String singleCharCase = s.substring(i, i + 1);
            result += romanValuesMap.get("" + singleCharCase);
            i += 1;

        }
        return result;
    }
}
