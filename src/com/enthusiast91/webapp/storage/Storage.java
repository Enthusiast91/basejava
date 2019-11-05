package com.enthusiast91.webapp.storage;

import com.enthusiast91.webapp.model.Resume;

import java.util.List;

public interface Storage {

    /**
     * Delete all resumes from storage
     */
    void clear();

    /**
     * Delete the resume at the specified uuid in storage
     */
    void delete(String uuid);

    /**
     * @return the resume at the specified uuid in storage
     */
    Resume get(String uuid);

    /**
     * @return array, contains only Resumes in storage (without null)
     */
//    Resume[] getAll();

//sorted by name
    List<Resume> getAllSorted();

    /**
     * Add resume in storage
     */
    void save(Resume resume);

    /**
     * @return the quantity of resumes in storage
     */
    int size();

    /**
     * Update resume in storage
     */
    void update(Resume resume);
}