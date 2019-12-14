package com.chris.cow;

import java.util.Map;

public class MainTest {
    public static void main(String[] args) {
        testCopyOnWriteHashMap();
//        testCopyOnWriteArrayList();
//        testCopyOnWriteHashSet();
    }

    private static void testCopyOnWriteHashSet() {
    }

    private static void testCopyOnWriteArrayList() {
    }

    private static void testCopyOnWriteHashMap() {
        Map<String, Object> map = new CopyOnWriteHashMap<>();
        map.put("1", "name1");
        map.put("2", "name2");
        map.put("3", "name3");
        map.put("4", "name4");
        map.put("5", "name5");

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if ("3".equals(entry.getKey())) {
                map.remove(entry.getKey());
            }
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
