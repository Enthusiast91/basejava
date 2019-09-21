package com.enthusiast91.webapp.storage;

import com.enthusiast91.webapp.exception.ExistStorageException;
import com.enthusiast91.webapp.exception.NotExistStorageException;
import com.enthusiast91.webapp.model.Resume;

public abstract class AbstractStorage implements Storage  {

    @Override
    public Resume get(String uuid) {
        int index = indexOf(uuid);
        if (index < 0) {
            throw new NotExistStorageException("Impossible to return resume. ", uuid);
        }
        return fetch(index, uuid);
    }

    @Override
    public void delete(String uuid) {
        int index = indexOf(uuid);
        if (index < 0) {
            throw new NotExistStorageException("Impossible to delete resume. ", uuid);
        }
        remove(index, uuid);
    }

    @Override
    public void save(Resume resume) {
        int index = indexOf(resume.getUuid());
        if (index >= 0) {
            throw new ExistStorageException("Impossible to add this resume. ", resume.getUuid());
        }
        add(index, resume);
    }

    @Override
    public void update(Resume resume) {
        int index = indexOf(resume.getUuid());
        if (index < 0) {
            throw new NotExistStorageException("Impossible to update this resume. ", resume.getUuid());
        }
        set(index, resume);
    }

    protected abstract int indexOf(String uuid);

    protected abstract void add(int index, Resume resume);

    protected abstract Resume fetch(int index, String uuid);

    protected abstract void set(int index, Resume resume);

    protected abstract void remove(int index, String uuid);
}
