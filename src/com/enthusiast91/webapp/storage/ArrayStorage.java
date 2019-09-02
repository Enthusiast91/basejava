package com.enthusiast91.webapp.storage;

import com.enthusiast91.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    public static final int MAX_SIZE = 10_000;
    private Resume[] storage = new Resume[MAX_SIZE];
    private int size = 0;

    /**
     * @return the index of occurrence of the specified Resume, or -1 if there is no such occurrence
     */
    public int indexOf(Resume resume) {
        return indexOf(resume.getUuid());
    }

    private int indexOf(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @return true if this storage contains this resume, false otherwise
     */
    public boolean contains(Resume resume) {
        return contains(resume.getUuid());
    }

    private boolean contains(String uuid) {
        return (indexOf(uuid) > -1);
    }

    /**
     * Update resume in this storage
     */
    public void update(Resume resume) {
        int index = indexOf(resume);
        if (index > -1) {
            storage[index] = resume;
        } else {
            System.out.println("Impossible to update this resume. Resume with UUID \""
                               + resume.getUuid() + "\" doesn't exist.");
        }
    }

    /**
     * Delete all resumes from this storage
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    /**
     * Delete all resumes from this storage
     */
    public void save(Resume r) {
        if (!contains(r)) {
            if (size < MAX_SIZE) {
                storage[size] = r;
                size++;
            } else {
                System.out.println("Storage is full");
            }
        } else {
            System.out.println("Impossible to add this resume. Resume with UUID \"" + r.getUuid() + "\" already exist.");
        }
    }

    /**
     * @return the resume at the specified uuid in this storage
     */
    public Resume get(String uuid) {
        int index = indexOf(uuid);
        if (index > -1) {
            return storage[index];
        } else {
            System.out.println("Impossible to return resume. Resume with UUID \"" + uuid + "\" doesn't exist.");
            return null;
        }
    }

    /**
     * Delete the resume at the specified uuid in this storage
     */
    public void delete(String uuid) {
        int index = indexOf(uuid);
        if (index > -1) {
            if (index != (size - 1)) {
                storage[index] = storage[size - 1];
            }
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("Impossible to delete resume. Resume with UUID \"" + uuid + "\" doesn't exist.");
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

    /**
     * @return the quantity of resumes in this storage
     */
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String s = "Storage is empty";
        if (size > 0) {
            Resume[] resumes = getAll();
            s = "[" + resumes[0];
            for (int i = 1; i < size; i++) {
                s += ", " + resumes[i];
            }
            s += "]";
        }
        return s;
    }
}