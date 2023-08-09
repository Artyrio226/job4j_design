package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class Search {
    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");
        search(start, p -> p.toFile().getName().endsWith(args[1])).forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
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