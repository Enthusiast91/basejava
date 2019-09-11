package com.enthusiast91.webapp.exception;

public class ExistStorageException extends StorageException {

    public ExistStorageException(String msg, String uuid) {
        super(msg + "Resume with UUID \"" + uuid + "\" already exist.", uuid);
    }
}
