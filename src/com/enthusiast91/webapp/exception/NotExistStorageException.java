package com.enthusiast91.webapp.exception;

public class NotExistStorageException extends StorageException {

    public NotExistStorageException(String msg, String uuid) {
        super(msg + "Resume with UUID \"" + uuid + "\" doesn't exist.", uuid);
    }
}
