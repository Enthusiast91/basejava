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
    protected void add(Object searchKey, Resume resume) {
        Integer index = (Integer) searchKey;
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        }
        insertElement(index, resume);
        size++;
    }

    @Override
    protected Resume doGet(Object searchKey) {
        Integer index = (Integer) searchKey;
        return storage[index];
    }

    @Override
    protected void set(Object searchKey, Resume resume) {
        Integer index = (Integer) searchKey;
        storage[index] = resume;
    }

    @Override
    protected void remove(Object searchKey) {
        Integer index = (Integer) searchKey;
        fillDeletedElement(index);
        storage[size - 1] = null;
        size--;
    }

    protected abstract void fillDeletedElement(int index);

    protected abstract void insertElement(int index, Resume resume);
}