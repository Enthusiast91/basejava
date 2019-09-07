package com.enthusiast91.webapp.storage;

import com.enthusiast91.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10_000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public void delete(String uuid) {
        int index = indexOf(uuid);
        if (index < 0) {
            System.out.println("Impossible to delete resume. Resume with UUID \"" + uuid + "\" doesn't exist.");
        } else {
            deleteImplementation(index);
            storage[size - 1] = null;
            size--;
        }
    }

    @Override
    public Resume get(String uuid) {
        int index = indexOf(uuid);
        if (index < 0) {
            System.out.println("Impossible to return resume. Resume with UUID \"" + uuid + "\" doesn't exist.");
            return null;
        }
        return storage[index];
    }

    @Override
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void update(Resume resume) {
        int index = indexOf(resume.getUuid());
        if (index < 0) {
            System.out.println("Impossible to update this resume. Resume with UUID \""
                    + resume.getUuid() + "\" doesn't exist.");
        } else {
            storage[index] = resume;
        }
    }

    @Override
    public void save(Resume resume) {
        int index = indexOf(resume.getUuid());
        if (index >= 0) {
            System.out.println("Impossible to add this resume. Resume with UUID \"" + resume.getUuid() + "\" already exist.");
        } else if (size == STORAGE_LIMIT) {
            System.out.println("Storage overflow");
        } else {
            insert(index, resume);
            size++;
        }
    }

    protected abstract void deleteImplementation(int index);

    protected abstract int indexOf(String uuid);

    protected abstract void insert(int index, Resume resume);
}