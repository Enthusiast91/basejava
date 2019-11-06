package com.enthusiast91.webapp.storage;

import com.enthusiast91.webapp.exception.StorageException;
import com.enthusiast91.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10_000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    protected abstract void fillDeletedElement(int index);

    protected abstract void insertElement(int index, Resume resume);

    @Override
    protected abstract Integer getSearchKey(String uuid);

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    protected List<Resume> getAll() {
        return Arrays.asList(Arrays.copyOfRange(storage, 0, size));
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    protected void doSave(Object searchKey, Resume resume) {
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
    protected void doUpdate(Object searchKey, Resume resume) {
        Integer index = (Integer) searchKey;
        storage[index] = resume;
    }

    @Override
    protected void doDelete(Object searchKey) {
        Integer index = (Integer) searchKey;
        fillDeletedElement(index);
        storage[size - 1] = null;
        size--;
    }
}