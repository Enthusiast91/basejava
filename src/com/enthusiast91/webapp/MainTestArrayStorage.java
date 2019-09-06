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
        final Resume r1 = new Resume("uuid1");
        final Resume r2 = new Resume("uuid2");
        final Resume r3 = new Resume("uuid3");
        final Resume r4 = new Resume("uuid4");

        printAll();
        ARRAY_STORAGE.clear();

        ARRAY_STORAGE.save(r4);
        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r3);
        ARRAY_STORAGE.save(r2);

        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        printAll();
        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy") + "\n");

        final Resume r3t = new Resume(r3.getUuid());
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
