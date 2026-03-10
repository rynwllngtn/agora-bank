package dev.rynwllngtn.exceptions.database;

import dev.rynwllngtn.exceptions.AgoraSystemException;

public class DatabaseException extends AgoraSystemException {
    public DatabaseException(String message) {
        super(message);
    }

    public static class DatabaseIntegrityException extends DatabaseException {
        public DatabaseIntegrityException(String message) {
            super(message);
        }
    }

}