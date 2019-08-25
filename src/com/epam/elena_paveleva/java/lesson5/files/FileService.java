package com.epam.elena_paveleva.java.lesson5.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
            System.out.println(((Files.size(file)) / (1024L * 1024L)) + " Mb   " + file);
        }
    }

    public static void printAverageFileSizeForAllSubfolders(Path path) throws IOException {
        if (!Files.isDirectory(path)) {
            throw new InvalidPathException("unable to get average file size", "path is not a directory");
        }

        List<Path> directories = FileService.listDirectories(path);
        for (Path directory : directories) {
            long avg = FileService.calculateAverageFileSizeInFolder(directory);
            if (avg == 0) {
                System.out.println("There is no files in folder: " + directory);
            } else {
                System.out.println("Average size size of file for " + directory + " : " + (avg / 1024L) + " Kb");
            }
        }
    }

    public static void printPathsByName(Path path) {
        if (!Files.isDirectory(path)) {
            throw new InvalidPathException("unable to get average file size", "path is not a directory");
        }
        try {
            countFilesByName(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void countFilesByName(Path path) throws IOException {
        class Counter {
            private int files = 0;
            private int directories = 0;

            private Counter(int f, int d) {
                files = f;
                directories = d;
            }
        }

        Map<Character, Counter> result = new HashMap<>();
        try (Stream<Path> walk = Files.walk(path)) {
            walk.forEach(x -> {
                char ch = x.getFileName().toString().toUpperCase().charAt(0);
                if (!result.containsKey(ch)) {
                    if (Files.isRegularFile(x)) {
                        result.put(ch, new Counter(1, 0));
                    } else {
                        result.put(ch, new Counter(0, 1));
                    }
                } else {
                    if (Files.isRegularFile(x)) {
                        result.get(ch).files++;
                    } else {
                        result.get(ch).directories++;
                    }
                }
            });
        } catch (IOException e) {
            throw new IOException(e);
        }

        if (!result.isEmpty()) {
            result.forEach((k, v) -> System.out.println(k + ": " + v.files + " files, " + v.directories + " directories"));
        }
    }

    private static long calculateAverageFileSizeInFolder(Path path) throws IOException {
        if (!Files.isDirectory(path)) {
            throw new InvalidPathException("unable to calculate average file size", "path is not a directory");
        }

        try (Stream<Path> walk = Files.walk(path, 1)) {
            List<Path> files = walk.filter(Files::isRegularFile).collect(Collectors.toList());
            long sum = 0;
            if (files.isEmpty()) {
                return sum;
            } else {
                for (Path file : files) {
                    sum += Files.size(file);
                }
                return (sum / files.size());
            }
        } catch (IOException e) {
            throw new IOException(e);
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
