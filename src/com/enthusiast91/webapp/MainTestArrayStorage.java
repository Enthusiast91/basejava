package com.enthusiast91.webapp;

import com.enthusiast91.webapp.model.Resume;
import com.enthusiast91.webapp.storage.SortedArrayStorage;
import com.enthusiast91.webapp.storage.Storage;

/**
 * Test for your com.enthusiast91.webapp.storage.ArrayStorage implementation
 */
public class MainTestArrayStorage {
    private static final Storage ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            ARRAY_STORAGE.save(new Resume("uuid" + i));
        }
//        final Resume r1 = new Resume("uuid1");
//        final Resume r2 = new Resume("uuid4");
//        final Resume r3 = new Resume("uuid3");
//        final Resume r4 = new Resume("uuid2");
//
//        System.out.println("Clear");
//        ARRAY_STORAGE.clear();
//        printAll();
//
//        System.out.println("\nAdding items");
//        System.out.print("Add r4. "); ARRAY_STORAGE.save(r4); printAll();
//        System.out.print("Add r1. "); ARRAY_STORAGE.save(r1); printAll();
//        System.out.print("Add r3. "); ARRAY_STORAGE.save(r3); printAll();
//        System.out.print("Add r2. "); ARRAY_STORAGE.save(r2); printAll();
//        System.out.println("Storage size: " + ARRAY_STORAGE.size());
//
//        System.out.println("\nGet r1 uuid: " + ARRAY_STORAGE.get(r1.getUuid()));
//        printAll();
//
////        System.out.println();
////        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));
//
//        final Resume r3t = new Resume(r3.getUuid());
//        System.out.println("\nUpdate r3");
//        ARRAY_STORAGE.update(r3t);
//        printAll();
//
//        System.out.println("\nDelete r1");
//        ARRAY_STORAGE.delete(r1.getUuid());
//        printAll();
//
//        System.out.println("\nClear storage");
//        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Storage size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
//        System.out.println("Get All: " + ARRAY_STORAGE.getAllSorted());
        for (Resume resume : ARRAY_STORAGE.getAllSorted()) {
            System.out.println(resume);
        }
    }
}
