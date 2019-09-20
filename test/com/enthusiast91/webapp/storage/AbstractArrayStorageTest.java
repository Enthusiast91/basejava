package com.enthusiast91.webapp.storage;

import com.enthusiast91.webapp.exception.ExistStorageException;
import com.enthusiast91.webapp.exception.NotExistStorageException;
import com.enthusiast91.webapp.exception.StorageException;
import com.enthusiast91.webapp.model.Resume;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {

    protected AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }



    @Test
    public void clear() {
        storage.clear();
        assertSize(0);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete("dummy");
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    @Test
    public void getAll() {
        Resume[] resumes = storage.getAll();
        assertEquals(size, resumes.length);
        assertEquals(RESUME_1, resumes[0]);
        assertEquals(RESUME_2, resumes[1]);
        assertEquals(RESUME_3, resumes[2]);
    }

    @Test(expected = ExistStorageException.class)
    public void saveAlreadyExist() {
        storage.save(RESUME_1);
    }

    @Test(expected = StorageException.class)
    public void getStorageOverflow() {
        try {
            for (int i = size; i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume());
            }
        } catch (StorageException e) {
                fail(e.toString());
        }
        storage.save(new Resume());
    }

    @Test
    public void size() {
        assertSize(size);
    }

    @Test (expected = NotExistStorageException.class)
    public void updateNotExist() {
        Resume nonExistentResume = new Resume();
        storage.update(nonExistentResume);
    }


}