package org.example;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Object, Integer> objects = new HashMap();
        objects.put(null, 9);
        String s = null;
        System.out.println(s.length());
    }
}