package com.enthusiast91.webapp.storage;

import com.enthusiast91.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public interface Storage {

    /**
     * Delete all resumes from this storage
     */
    void clear();

    /**
     * Delete the resume at the specified uuid in this storage
     */
    void delete(String uuid);

    /**
     * @return the resume at the specified uuid in this storage
     */
    Resume get(String uuid);

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll();

    /**
     * Delete all resumes from this storage
     */
    void save(Resume resume);

    /**
     * @return the quantity of resumes in this storage
     */
    int size();

    /**
     * Update resume in this storage
     */
    void update(Resume resume);
}