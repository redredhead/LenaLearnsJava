package com.epam.elena_paveleva.java.lesson5.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileService {
    public static List<Path> listFiles(Path path) throws IOException {
        try (Stream<Path> walk = Files.walk(path)) {
            return walk.filter(Files::isRegularFile)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    public static List<Path> listDirectories(Path path) throws IOException {
        try (Stream<Path> walk = Files.walk(path)) {
            return walk.filter(Files::isDirectory)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    public static void findMaxSymbolFile(List<Path> files, char symbol) {
        int maxSymbolCounter = 0;
        List<Path> maxSymbolFiles = new ArrayList<>();
        for (Path file : files) {
            int counter = countCharInFilename(file, symbol);
            if (counter > maxSymbolCounter) {
                maxSymbolFiles.clear();
                maxSymbolFiles.add(file);
                maxSymbolCounter = counter;
            } else if (counter != 0 && (maxSymbolFiles.isEmpty() || counter == maxSymbolCounter)) {
                maxSymbolFiles.add(file);
                maxSymbolCounter = counter;
            }
        }

        if (!maxSymbolFiles.isEmpty()) {
            System.out.println("List of files with maximum amount " + maxSymbolCounter + " of symbol " + symbol + ":");
            for (Path file : maxSymbolFiles) {
                System.out.println(file.toString());
            }
        } else {
            System.out.println("No files containing " + symbol + " found");
        }

    }

    public static List<Path> sortBySize(List<Path> files) {
        List<Path> sortedFiles = new ArrayList<>(files);
        sortedFiles.sort((o1, o2) -> {
            try {
                return (int) (Files.size(o2) - Files.size(o1));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return 0;
        });
        return sortedFiles;
    }

    public static void printLargestFiles(List<Path> files, int amount) throws IOException {
        files = FileService.sortBySize(files);
        files.subList(amount, files.size()).clear();
        System.out.println("Top " + amount + " largest files in directory:");
        for (Path file : files) {
            System.out.println(((Files.size(file)) / (1024L * 1024L)) + " Mb   " + file.toString());
        }

    }

    private static int countCharInFilename(Path file, char symbol) {
        String filename = file.getFileName().toString();
        if (filename.contains(".")) {
            filename = filename.substring(0, filename.lastIndexOf('.'));
        }
        return (int) filename.chars().filter(ch -> ch == symbol).count();

    }
}
