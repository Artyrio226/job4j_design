package ru.job4j.io;

import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFiles extends SimpleFileVisitor<Path> {
    private List<Path> list = new ArrayList<>();
    private String ext;
    public SearchFiles(String condition) {
        ext = condition;
    }

    public List<Path> getPaths() {
        return list;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        if (file.toFile().getName().endsWith(ext)) {
            list.add(file);
        }
        return FileVisitResult.CONTINUE;
    }
}
