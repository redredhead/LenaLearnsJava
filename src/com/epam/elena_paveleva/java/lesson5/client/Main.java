package com.epam.elena_paveleva.java.lesson5.client;

import com.epam.elena_paveleva.java.lesson5.files.FileService;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Users\\Evgenii\\Downloads");
        int number = 2;

        switch (number) {
            case 1:
                FileService.findMaxSymbolFile(FileService.listFiles(path), 's');
                break;

            case 2:
                List<Path> files = FileService.listFiles(path);
                FileService.printLargestFiles(files, 5);
        }
    }
}
