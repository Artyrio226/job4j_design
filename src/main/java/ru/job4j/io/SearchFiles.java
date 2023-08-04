package ru.job4j.io;

import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchFiles extends SimpleFileVisitor<Path> {
    private List<Path> list = new ArrayList<>();
    private Predicate<Path> pred;
    public SearchFiles(Predicate<Path> condition) {
        pred = condition;
    }

    public List<Path> getPaths() {
        return list;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        if (pred.test(file)) {
            list.add(file);
        }
        return FileVisitResult.CONTINUE;
    }
}
