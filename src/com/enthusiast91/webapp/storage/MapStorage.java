package com.enthusiast91.webapp.storage;

import com.enthusiast91.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private final Map<String, Resume> storage = new HashMap<>();

    public void clear() {
        storage.clear();
    }

    @Override
    public Resume[] getAll() {
        return storage.values().toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected boolean resumeWithKeyExist(Object searchKey) {
        String uuid = (String) searchKey;
        return storage.containsKey(uuid);
    }

    /**
     * @return +1 if Resume is present, or -1 if not
     */
    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected void add(Object searchKey, Resume resume) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        String uuid = (String) searchKey;
        return storage.get(uuid);
    }

    @Override
    protected void set(Object searchKey, Resume resume) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected void remove(Object searchKey) {
        String uuid = (String) searchKey;
        storage.remove(uuid);
    }
}
