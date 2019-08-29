package com.epam.elena_paveleva.java.lesson5.client;

import com.epam.elena_paveleva.java.lesson5.files.FileService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    private static int AMOUNT_OF_TASKS = 4;

    public static void main(String[] args) {

        if (validateInput(args)) {
            try {
                int task = Integer.parseInt(args[0]);
                Path path = Paths.get(args[1]);
                execute(task, path);
            } catch (IOException e) {
                System.out.println("Something went wrong");
                e.printStackTrace();
            }
        } else {
            System.out.println("Input not valid");
        }
    }

    private static void execute(int task, Path path) throws IOException {
        List<Path> files;
        switch (task) {
            case 1:
                FileService.findMaxSymbolFile(FileService.listFiles(path), 's');
                break;

            case 2:
                files = FileService.listFiles(path);
                FileService.printLargestFiles(files, 5);
                break;

            case 3:
                FileService.printAverageFileSizeForAllSubfolders(path);
                break;

            case 4:
                FileService.printPathsByName(path);
                break;
        }
    }

    private static boolean validateInput(String[] args) {
        int task;
        Path path;
        if (args.length != 2) {
            return false;
        }
        try {
            task = Integer.parseInt(args[0]);
            path = Paths.get(args[1]);
        } catch (NumberFormatException | InvalidPathException e) {
            return false;
        }

        return Files.exists(path) && Files.isDirectory(path) && task <= AMOUNT_OF_TASKS && task > 0;
    }
}
