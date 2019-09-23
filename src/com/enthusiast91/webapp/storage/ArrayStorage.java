package com.enthusiast91.webapp.storage;

import com.enthusiast91.webapp.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void fillDeletedElement(int index) {
        storage[index] = storage[size - 1];
    }

    @Override
    protected boolean resumeWithKeyExist(Object searchKey) {
        //if (searchKey == null || Integer.class != searchKey.getClass()) return false;
        Integer resume = (Integer) searchKey;
        return resume >= 0;
    }

    /**
     * @return the index of occurrence of Resume of the specified uuid, or -1 if there is no such occurrence
     */
    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void insertElement(int index, Resume resume) {
        storage[size] = resume;
    }

    @Override
    protected Resume doGet(Object searchKey) {
        Integer index = (Integer) searchKey;
        return storage[index];
    }
}