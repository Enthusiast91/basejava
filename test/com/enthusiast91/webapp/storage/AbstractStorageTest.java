package com.enthusiast91.webapp.storage;

import com.enthusiast91.webapp.exception.ExistStorageException;
import com.enthusiast91.webapp.exception.NotExistStorageException;
import com.enthusiast91.webapp.model.Resume;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public abstract class AbstractStorageTest {
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    private static final Resume RESUME_1 = new Resume(UUID_1, "Name1");
    private static final Resume RESUME_2 = new Resume(UUID_2, "Name2");
    private static final Resume RESUME_3 = new Resume(UUID_3, "Name3");
    private static final Resume RESUME_4 = new Resume(UUID_4, "Name4");
    protected Storage storage;

    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUpTest() {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void clearTest() {
        storage.clear();
        assertSize(0);
    }

    @Test
    public void deleteTest() {
        int storageSizeAfterDelete = storage.size() - 1;
        storage.delete(UUID_1);
        assertSize(storageSizeAfterDelete);

        try { storage.get(UUID_1); }
        catch (NotExistStorageException e) { return; }
        fail("Resume not deleted");
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete("dummy");
    }

    @Test
    public void getTest() {
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExistTest() {
        storage.get("dummy");
    }

    @Test
    public void getAllSortedTest() {
        List<Resume> listActual = storage.getAllSorted();
        assertThat(listActual, CoreMatchers.hasItems(RESUME_1, RESUME_2, RESUME_3));
    }

    @Test
    public void saveTest() {
        int storageSizeAfterAdd = storage.size() + 1;
        storage.save(RESUME_4);

        assertSize(storageSizeAfterAdd);
        assertGet(RESUME_4);
    }

    @Test(expected = ExistStorageException.class)
    public void saveAlreadyExistTest() {
        storage.save(RESUME_1);
    }

    @Test
    public void sizeTest() {
        assertSize(3);
    }

    @Test
    public void updateTest() {
        Resume newResume = new Resume(UUID_1, "Name");
        storage.update(newResume);
        assertSame(newResume, storage.get(UUID_1));
    }

    @Test (expected = NotExistStorageException.class)
    public void updateNotExistTest() {
        Resume nonExistentResume = new Resume("dummy");
        storage.update(nonExistentResume);
    }

    private void assertSize(int size) {
        assertEquals(size, storage.size());
    }

    private void assertGet(Resume resume) {
        assertEquals(resume, storage.get(resume.getUuid()));
    }
}