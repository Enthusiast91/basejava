package com.enthusiast91.webapp;

import com.enthusiast91.webapp.model.Resume;
import com.enthusiast91.webapp.storage.ArrayStorage;

/**
 * Test for your com.enthusiast91.webapp.storage.ArrayStorage implementation
 */
public class MainTestArrayStorage {
    static final ArrayStorage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) {
        Resume r1 = new Resume();
        r1.setUuid("uuid1");
        Resume r2 = new Resume();
        r2.setUuid("uuid2");
        Resume r3 = new Resume();
        r3.setUuid("uuid3");

        printAll();
        ARRAY_STORAGE.clear();

        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r3);

        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        printAll();
        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy") + "\n");

        Resume r3t = new Resume();
        r3t.setUuid(r3.getUuid());
        ARRAY_STORAGE.update(r3t);
        System.out.println("Update r3: " + ARRAY_STORAGE.get(r3t.getUuid()));

        printAll();
        ARRAY_STORAGE.delete(r1.getUuid());
        printAll();
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
        System.out.print("\nGet All\n[ ");
        for (Resume r : ARRAY_STORAGE.getAll()) {
            System.out.print(r + " ");
        }
        System.out.println("]");
    }
}
