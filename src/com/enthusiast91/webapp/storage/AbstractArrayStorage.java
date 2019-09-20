package com.enthusiast91.webapp.storage;

import com.enthusiast91.webapp.exception.StorageException;
import com.enthusiast91.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10_000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
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
    protected void add(int index, Resume resume) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        } else {
            insertElement(index, resume);
            size++;
        }
    }

    @Override
    protected Resume get(int index) {
        return storage[index];
    }

    @Override
    protected void set(int index, Resume resume) {
        storage[index] = resume;
    }

    @Override
    protected void remove(int index) {
        fillDeletedElement(index);
        storage[size - 1] = null;
        size--;
    }

    protected abstract void fillDeletedElement(int index);

    protected abstract void insertElement(int index, Resume resume);
}