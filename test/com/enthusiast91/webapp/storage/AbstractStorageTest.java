package com.enthusiast91.webapp.storage;

import com.enthusiast91.webapp.exception.NotExistStorageException;
import com.enthusiast91.webapp.model.Resume;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class AbstractStorageTest {
    protected static final String UUID_1 = "uuid1";
    protected static final String UUID_2 = "uuid2";
    protected static final String UUID_3 = "uuid3";
    protected static final String UUID_4 = "uuid4";
    protected static final Resume RESUME_1 = new Resume(UUID_1);
    protected static final Resume RESUME_2 = new Resume(UUID_2);
    protected static final Resume RESUME_3 = new Resume(UUID_3);
    protected static final Resume RESUME_4 = new Resume(UUID_4);
    protected static int size;
    protected Storage storage;

    protected AbstractStorageTest(Storage storage) {
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
    public void get() {
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
    }

    @Test
    public void delete() {
        storage.delete(UUID_1);
        int storageSizeAfterDelete = size - 1;
        assertSize(storageSizeAfterDelete);

        try { storage.get(UUID_1); }
        catch (NotExistStorageException e) { return; }
        fail("Resume not deleted");
    }

    @Test
    public void save() {
        storage.save(RESUME_4);
        int storageSizeAfterAdd = size + 1;
        assertSize(storageSizeAfterAdd);
        assertGet(RESUME_4);
    }

    @Test
    public void update() {
        Resume newResume = new Resume(UUID_1);
        storage.update(newResume);
        assertSame(newResume, storage.get(UUID_1));
    }

    protected void assertSize(int size) {
        assertEquals(size, storage.size());
    }

    protected void assertGet(Resume resume) {
        assertEquals(resume, storage.get(resume.getUuid()));
    }
}