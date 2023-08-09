package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.regex.Pattern;

public class Search {
    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");
        search(start, ".txt").forEach(System.out::println);
    }

    public static List<Path> search(Path root, String extension) throws IOException {
        validate(root, extension);
        SearchFiles overSearch = new SearchFiles(extension) {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                if (!file.toFile().getName().endsWith(extension)) {
                    list.add(file);
                }
                return FileVisitResult.CONTINUE;
            }
        };
        Files.walkFileTree(root, overSearch);
        return overSearch.getPaths();
    }

    private static void validate(Path root, String extension) {
        if (!root.toFile().exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", root.isAbsolute()));
        }
        if (!root.toFile().isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", root.isAbsolute()));
        }
        if (!Pattern.matches("[.][a-zA-Z0-9]{1,255}", extension)) {
            throw new IllegalArgumentException(String.format("Not extension %s", extension));
        }
    }
}