package com.enthusiast91.webapp.storage;

import com.enthusiast91.webapp.exception.ExistStorageException;
import com.enthusiast91.webapp.exception.NotExistStorageException;
import com.enthusiast91.webapp.exception.StorageException;
import com.enthusiast91.webapp.model.Resume;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class AbstractArrayStorageTest {
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    private static final Resume RESUME_1 = new Resume(UUID_1);
    private static final Resume RESUME_2 = new Resume(UUID_2);
    private static final Resume RESUME_3 = new Resume(UUID_3);
    private static final Resume RESUME_4 = new Resume(UUID_4);
    private static int size;
    private Storage storage;

    protected AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
        size = 3;
    }

    @Test
    public void clear() {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    public void delete() {
        storage.delete(UUID_1);
        int storageSizeAfterDelete = size - 1;
        assertEquals(storageSizeAfterDelete, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete("dummy");
    }

    @Test
    public void get() {
        Resume resultResume = storage.get(UUID_1);
        assertEquals(RESUME_1, resultResume);
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

    @Test
    public void save() {
        storage.save(RESUME_4);
        int storageSizeAfterAdd = size + 1;
        assertEquals(storageSizeAfterAdd, storage.size());
        Resume savedResume = storage.get(UUID_4);
        assertEquals(RESUME_4, savedResume);
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
        assertEquals(size, storage.size());
    }

    @Test
    public void update() {
        Resume oldResume = storage.get(UUID_1);
        storage.update(new Resume(UUID_1));
        Resume newResume = storage.get(UUID_1);
        assertEquals(oldResume, newResume);
    }

    @Test (expected = NotExistStorageException.class)
    public void updateNotExist() {
        Resume nonExistentResume = new Resume();
        storage.update(nonExistentResume);
    }
}