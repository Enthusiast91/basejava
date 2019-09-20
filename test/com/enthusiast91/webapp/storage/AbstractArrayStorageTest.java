package com.enthusiast91.webapp.storage;

import com.enthusiast91.webapp.exception.StorageException;
import com.enthusiast91.webapp.model.Resume;
import org.junit.Test;

import static org.junit.Assert.fail;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {

    protected AbstractArrayStorageTest(Storage storage) {
        super(storage);
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
}