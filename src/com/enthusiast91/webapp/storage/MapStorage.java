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

    /**
     * @return +1 if Resume is present, or -1 if not
     */
    @Override
    protected int indexOf(String uuid) {
        return storage.containsKey(uuid) ? 1 : -1;
    }

    @Override
    protected void add(int index, Resume resume) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume fetch(int index, String uuid) {
        return storage.get(uuid);
    }

    @Override
    protected void set(int index, Resume resume) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected void remove(int index, String uuid) {
        storage.remove(uuid);
    }
}
