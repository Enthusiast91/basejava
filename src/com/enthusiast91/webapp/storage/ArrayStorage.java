package com.enthusiast91.webapp.storage;

import com.enthusiast91.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private static final int MAX_SIZE = 10_000;
    private Resume[] storage = new Resume[MAX_SIZE];
    private int size = 0;

    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    public void save(Resume r) {
        if (size < MAX_SIZE) {
            storage[size] = r;
            size++;
        } else {
            System.out.println("Хранилище переполнено.");
        }
    }

    public Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid()))
                return storage[i];
        }
        return null;
    }

    public void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                if (i == MAX_SIZE - 1)
                    storage[i] = null;
                for (int j = i + 1; j < size; j++) {
                    storage[j - 1] = storage[j];
                }
                size--;
                return;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] resumes = new Resume[size];
        for (int i = 0; i < size; i++) {
            resumes[i] = storage[i];
        }
        return resumes;
    }

    public int size() {
        return size;
    }
}
