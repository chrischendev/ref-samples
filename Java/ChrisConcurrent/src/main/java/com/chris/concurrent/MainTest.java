package com.chris.concurrent;

import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class MainTest {
    public static void main(String[] args){
        testArrayBlockingQueue();
    }

    private static void testArrayBlockingQueue() {
        BlockingQueue queue=new ArrayBlockingQueue(2);
        try {
            queue.put(1);
            queue.put(2);
            queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void testConcurrentMap() {
        Map<String,Object> map=new ConcurrentHashMap<>();
        map.put("1","kalychen1");
        map.put("2","kalychen2");
        map.put("3","kalychen3");
        map.put("4","kalychen4");

        for (String key:map.keySet()){
            if ("3".equals(key)){
                map.remove(key);
            }
        }
        System.out.println(map.size());
    }
}
