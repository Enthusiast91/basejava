package com.enthusiast91.webapp.storage;

import com.enthusiast91.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    public void save(Resume resume) {
        if (indexOf(resume.getUuid()) != -1) {
            System.out.println("Impossible to add this resume. Resume with UUID \"" + resume.getUuid() + "\" already exist.");
        } else if (size == STORAGE_LIMIT) {
            System.out.println("Storage overflow");
        } else {
            storage[size] = resume;
            size++;
        }
    }

    @Override
    protected void deleteImplementation(int index) {
        storage[index] = storage[size - 1];
        storage[size - 1] = null;
    }

    /**
     * @return the index of occurrence of Resume of the specified uuid, or -1 if there is no such occurrence
     */
     protected int indexOf(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}