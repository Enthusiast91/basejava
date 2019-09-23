package com.enthusiast91.webapp.storage;

import com.enthusiast91.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private final List<Resume> storage = new ArrayList<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public Resume[] getAll() {
        return storage.toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected boolean resumeWithKeyExist(Object searchKey) {
        Integer resume = (Integer) searchKey;
        return resume >= 0;
    }

    /**
     * @return the index of occurrence of Resume of the specified uuid, or -1 if there is no such occurrence
     */
    @Override
    protected Integer getSearchKey(String uuid) {
        int size = storage.size();
        for (int i = 0; i < size; i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void add(Object searchKey, Resume resume) {
        storage.add(resume);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        Integer index = (Integer) searchKey;
        return storage.get(index);
    }

    @Override
    protected void set(Object searchKey, Resume resume) {
        Integer index = (Integer) searchKey;
        storage.set(index, resume);
    }

    @Override
    protected void remove(Object searchKey) {
        int index = (int) searchKey;
        storage.remove(index);
    }
}
