package com.enthusiast91.webapp.storage;

import com.enthusiast91.webapp.model.Resume;

public class MapUuidStorage extends AbstractMapStorage {

    @Override
    protected boolean isExist(Object searchKey) {
        String uuid = (String) searchKey;
        return storage.containsKey(uuid);
    }

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected void doSave(Object searchKey, Resume resume) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        String uuid = (String) searchKey;
        return storage.get(uuid);
    }

    @Override
    protected void doDelete(Object searchKey) {
        storage.remove(searchKey);
    }
}