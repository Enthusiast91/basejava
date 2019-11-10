package com.enthusiast91.webapp.storage;

import com.enthusiast91.webapp.model.Resume;

public class MapResumeStorage extends AbstractMapStorage {

    @Override
    protected boolean isExist(Object searchKey) {
        return storage.containsKey(((Resume) searchKey).getUuid());
    }

    @Override
    protected Resume getSearchKey(String uuid) {
        return new Resume(uuid, "Name");
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return storage.get(((Resume) searchKey).getUuid());
    }

    @Override
    protected void doDelete(Object searchKey) {
        storage.remove(((Resume) searchKey).getUuid());
    }
}