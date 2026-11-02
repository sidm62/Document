package org.example;

public class AccessDeniedEception extends RuntimeException {
    public AccessDeniedEception(String message) {
        super(message);
    }
}
