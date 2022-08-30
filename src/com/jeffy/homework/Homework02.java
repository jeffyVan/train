package com.jeffy.homework;

import java.util.*;

@SuppressWarnings("all")
public class Homework02 {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("jack",650);
        map.put("tom",120);
        map.put("smith",2900);

        System.out.println(map);
        System.out.println("======================");

        map.put("jack",2600);
        System.out.println(map);
        System.out.println("======================");

        Set keySet = map.keySet();
        for (Object key : keySet) {
            map.put(key,(Integer)map.get(key)+100);
        }
        System.out.println(map);
        System.out.println("======================");


        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.print(next+" ");
        }
        System.out.println();
        System.out.println("======================");
        Collection values = map.values();
        for (Object value : values) {
            System.out.print(value+" ");
        }

        /*Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();


            System.out.println(next);
        }*/
//        System.out.println(set);

    }
}
