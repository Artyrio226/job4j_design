package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private Map<FileProperty, List<Path>> map = new HashMap<>();

    public void getDuplicates() {
        map.forEach((key, value) -> {
            if (value.size() > 1) {
                System.out.printf("%s - %d%n", key.getName(), key.getSize());
                value.forEach(a -> System.out.println(a.toAbsolutePath()));
            }
        });
    }
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fp = new FileProperty(attrs.size(), file.toFile().getName());
        map.computeIfAbsent(fp, k -> new LinkedList<>()).add(file);
        return FileVisitResult.CONTINUE;
    }
}