package com.nahalit.realestateapimanager.exception;

import com.nahalit.realestateapimanager.exception.StorageException;

public class StorageFileNotFoundException extends StorageException {

    public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}