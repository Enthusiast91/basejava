package com.enthusiast91.webapp.storage;

import com.enthusiast91.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage implements Storage{
    private static final int STORAGE_LIMIT = 10_000;
    private final Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size = 0;

    @Override
    public void update(Resume resume) {
        int index = indexOf(resume.getUuid());
        if (index == -1) {
            System.out.println("Impossible to update this resume. Resume with UUID \""
                    + resume.getUuid() + "\" doesn't exist.");
        } else {
            storage[index] = resume;
        }
    }

    @Override
    public void clear() {
        if (size > 0) {
            Arrays.fill(storage, 0, size, null);
            size = 0;
        }
    }

    @Override
    public void save(Resume resume) {
        if (indexOf(resume.getUuid()) != -1) {
            System.out.println("Impossible to add this resume. Resume with UUID \"" + resume.getUuid() + "\" already exist.");
        } else if (size == STORAGE_LIMIT) {
            System.out.println("Storage overflow");
        } else {
            storage[size] = resume;
            size++;
        }
    }

    @Override
    public Resume get(String uuid) {
        int index = indexOf(uuid);
        if (index == -1) {
            System.out.println("Impossible to return resume. Resume with UUID \"" + uuid + "\" doesn't exist.");
            return null;
        }
        return storage[index];
    }

    @Override
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

    @Override
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    @Override
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