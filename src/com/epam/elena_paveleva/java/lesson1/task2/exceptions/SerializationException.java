package com.epam.elena_paveleva.java.lesson1.task2.exceptions;

public class SerializationException extends Exception {

    public SerializationException(String message, Exception e) {
        super(message, e);
    }

    public SerializationException(Exception e) {
        super(e);
    }
}
