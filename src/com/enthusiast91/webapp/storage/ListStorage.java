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
    protected List<Resume> getAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return searchKey != null;
    }

    /**
     * @return the index of the Resume occurrence of the specified uuid, or null if there is no such occurrence
     */
    @Override
    protected Integer getSearchKey(String uuid) {
        int size = storage.size();
        for (int i = 0; i < size; i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected void doSave(Object searchKey, Resume resume) {
        storage.add(resume);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        Integer index = (Integer) searchKey;
        return storage.get(index);
    }

    @Override
    protected void doUpdate(Object searchKey, Resume resume) {
        Integer index = (Integer) searchKey;
        storage.set(index, resume);
    }

    @Override
    protected void doDelete(Object searchKey) {
        int index = (int) searchKey;
        storage.remove(index);
    }
}
