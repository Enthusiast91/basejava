package com.enthusiast91.webapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestSingleton {
    private static TestSingleton instance;

    private TestSingleton() {}

    public static TestSingleton getInstance() {
        if (instance == null) {
            instance = new TestSingleton();
        }
        return instance;
    }

    public static void main(String[] args) {
//        Singleton instance = Singleton.valueOf("INSTANCE");
//        System.out.println(instance.ordinal());
//
//        for (SectionType type : SectionType.values()) {
//            System.out.println(type.getTitle());
//        }

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int index = 5;
        if (index >= 0 && index <= list.size()) {
            list.add(index, 6);
        }
        System.out.println(list);
    }

    public enum Singleton {
        INSTANCE;
    }
}
