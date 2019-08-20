package com.epam.elena_paveleva.java.lesson5.client;

import com.epam.elena_paveleva.java.lesson5.files.FileService;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Users\\Evgenii\\Downloads");
        try {
            FileService.listFiles(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
