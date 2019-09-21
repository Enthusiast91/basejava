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

    /**
     * @return the index of occurrence of Resume of the specified uuid, or -1 if there is no such occurrence
     */
    @Override
    protected int indexOf(String uuid) {
        int size = storage.size();
        for (int i = 0; i < size; i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void add(int index, Resume resume) {
        storage.add(resume);
    }

    @Override
    protected Resume fetch(int index, String uuid) {
        return storage.get(index);
    }

    @Override
    protected void set(int index, Resume resume) {
        storage.set(index, resume);
    }

    @Override
    protected void remove(int index, String uuid) {
        storage.remove(index);
    }
}
