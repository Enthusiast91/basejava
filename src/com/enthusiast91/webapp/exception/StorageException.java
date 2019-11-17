package com.enthusiast91.webapp.exception;

import java.util.logging.Logger;

public class StorageException extends RuntimeException {
    private static Logger LOG = Logger.getLogger(StorageException.class.getSimpleName());
    private final String uuid;

    public  StorageException(String msg, String uuid) {
        super(msg);
        //LOG.log(Level.SEVERE, "StorageException", this);
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }
}
