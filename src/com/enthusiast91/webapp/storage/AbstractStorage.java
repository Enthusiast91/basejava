package com.enthusiast91.webapp.storage;

import com.enthusiast91.webapp.exception.ExistStorageException;
import com.enthusiast91.webapp.exception.NotExistStorageException;
import com.enthusiast91.webapp.model.Resume;

public abstract class AbstractStorage implements Storage  {

    @Override
    public Resume get(String uuid) {
        Object searchKey = getSearchKey(uuid);
        checkAtNonExist(uuid, searchKey);
        return doGet(searchKey);
    }

    @Override
    public void delete(String uuid) {
        Object searchKey = getSearchKey(uuid);
        checkAtNonExist(uuid, searchKey);
        remove(searchKey);
    }

    @Override
    public void save(Resume resume) {
        String uuid = resume.getUuid();
        Object searchKey = getSearchKey(uuid);
        if (resumeWithKeyExist(searchKey)) {
            throw new ExistStorageException("Impossible to add this resume. ", uuid);
        }
        add(searchKey, resume);
    }

    @Override
    public void update(Resume resume) {
        String uuid = resume.getUuid();
        Object searchKey = getSearchKey(uuid);
        checkAtNonExist(uuid, searchKey);
        set(searchKey, resume);
    }

    private void checkAtNonExist(String uuid, Object searchKey) {
        if (!resumeWithKeyExist(searchKey)) {
            throw new NotExistStorageException("Impossible to update this resume. ", uuid);
        }
    }

    protected abstract boolean resumeWithKeyExist(Object searchKey);

    protected abstract Object getSearchKey(String uuid);

    protected abstract void add(Object searchKey, Resume resume);

    protected abstract Resume doGet(Object searchKey);

    protected abstract void set(Object searchKey, Resume resume);

    protected abstract void remove(Object searchKey);
}
