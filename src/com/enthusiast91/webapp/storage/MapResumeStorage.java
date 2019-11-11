package com.enthusiast91.webapp.storage;

import com.enthusiast91.webapp.model.Resume;

public class MapResumeStorage extends AbstractMapStorage {

    @Override
    protected boolean isExist(Object searchKey) {
        return searchKey != null;
    }

    @Override
    protected Resume getSearchKey(String uuid) {
        return storage.get(uuid);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return (Resume) searchKey;
    }

    @Override
    protected void doDelete(Object searchKey) {
        storage.remove(((Resume)searchKey).getUuid());
    }
}