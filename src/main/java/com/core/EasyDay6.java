package com.core;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class EasyDay6 {

    public static void main(String args[]){
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1,10);
        myHashMap.put(2,20);
        myHashMap.get(2);
        myHashMap.remove(1);
    }

    static class MyHashMap {

        int[] map;

        /** Initialize your data structure here. */
        public MyHashMap() {
            map = new int[1000001];
            Arrays.fill(map, -1);

        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            map[key] = value;
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            return  map[key];

        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            map[key] = -1;
        }

    }
}
