package com.enthusiast91.webapp.storage;

import com.enthusiast91.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    public static final int MAX_SIZE = 10_000;
    private Resume[] storage = new Resume[MAX_SIZE];
    private int size = 0;

    /**
     * Update resume in this storage
     */
    public void update(Resume resume) {
        int index = indexOf(resume.getUuid());
        if (index == -1) {
            System.out.println("Impossible to update this resume. Resume with UUID \""
                    + resume.getUuid() + "\" doesn't exist.");
        } else {
            storage[index] = resume;
        }
    }

    /**
     * Delete all resumes from this storage
     */
    public void clear() {
        if (size > 0) {
            Arrays.fill(storage, 0, size - 1, null);
            size = 0;
        }
    }

    /**
     * Delete all resumes from this storage
     */
    public void save(Resume resume) {
        int index = indexOf(resume.getUuid());
        if (index != -1) {
            System.out.println("Impossible to add this resume. Resume with UUID \"" + resume.getUuid() + "\" already exist.");
        } else if (size == MAX_SIZE) {
            System.out.println("Storage overflow");
        } else {
            storage[size] = resume;
            size++;
        }
    }

    /**
     * @return the resume at the specified uuid in this storage
     */
    public Resume get(String uuid) {
        int index = indexOf(uuid);
        if (index == -1) {
            System.out.println("Impossible to return resume. Resume with UUID \"" + uuid + "\" doesn't exist.");
            return null;
        }
        return storage[index];
    }

    /**
     * Delete the resume at the specified uuid in this storage
     */
    public void delete(String uuid) {
        int index = indexOf(uuid);
        if (index == -1) {
            System.out.println("Impossible to delete resume. Resume with UUID \"" + uuid + "\" doesn't exist.");
        } else {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    /**
     * @return the quantity of resumes in this storage
     */
    public int size() {
        return size;
    }

    /**
     * @return the index of occurrence of Resume of the specified uuid, or -1 if there is no such occurrence
     */
    private int indexOf(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}