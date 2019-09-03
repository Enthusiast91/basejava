package com.enthusiast91.webapp.storage;

import com.enthusiast91.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public interface Storage {
    /**
     * Update resume in this storage
     */
    void update(Resume resume);

    /**
     * Delete all resumes from this storage
     */
    void clear();

    /**
     * Delete all resumes from this storage
     */
    void save(Resume resume);

    /**
     * @return the resume at the specified uuid in this storage
     */
    Resume get(String uuid);

    /**
     * Delete the resume at the specified uuid in this storage
     */
    void delete(String uuid);

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll();

    /**
     * @return the quantity of resumes in this storage
     */
    int size();
}