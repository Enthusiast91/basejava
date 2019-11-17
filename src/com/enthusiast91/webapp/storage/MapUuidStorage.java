package com.enthusiast91.webapp.storage;

import com.enthusiast91.webapp.model.Resume;

public class MapUuidStorage extends AbstractMapStorage<String> {

    @Override
    protected boolean isExist(String uuid) {
        return storage.containsKey(uuid);
    }

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected void doSave(String uuid, Resume resume) {
        storage.put(uuid, resume);
    }

    @Override
    protected Resume doGet(String uuid) {
        return storage.get(uuid);
    }

    @Override
    protected void doDelete(String uuid) {
        storage.remove(uuid);
    }
}