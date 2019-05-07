package com.epam.elena_paveleva.java.lesson1.task2.exceptions;

import java.io.IOException;

public class ObjectNotFoundException extends Exception {
    String type;

    public ObjectNotFoundException(String searchedType) {
        type = searchedType;
    }

    public void printMessage() {
        System.out.println("Requested " + type + " not found");
    }
}
