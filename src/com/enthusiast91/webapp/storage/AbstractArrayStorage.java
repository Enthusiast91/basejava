package com.enthusiast91.webapp.storage;

import com.enthusiast91.webapp.exception.ExistStorageException;
import com.enthusiast91.webapp.exception.NotExistStorageException;
import com.enthusiast91.webapp.exception.StorageException;
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
            throw new NotExistStorageException("Impossible to delete resume. ", uuid);
        } else {
            fillDeletedElement(index);
            storage[size - 1] = null;
            size--;
        }
    }

    @Override
    public Resume get(String uuid) {
        int index = indexOf(uuid);
        if (index < 0) {
            throw new NotExistStorageException("Impossible to return resume. ", uuid);
        }
        return storage[index];
    }

    @Override
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    @Override
    public void save(Resume resume) {
        int index = indexOf(resume.getUuid());
        if (index >= 0) {
            throw new ExistStorageException("Impossible to add this resume. ", resume.getUuid());
        } else if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        } else {
            insertElement(index, resume);
            size++;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void update(Resume resume) {
        int index = indexOf(resume.getUuid());
        if (index < 0) {
            throw new NotExistStorageException("Impossible to update this resume. ", resume.getUuid());
        } else {
            storage[index] = resume;
        }
    }

    protected abstract void fillDeletedElement(int index);

    protected abstract int indexOf(String uuid);

    protected abstract void insertElement(int index, Resume resume);
}