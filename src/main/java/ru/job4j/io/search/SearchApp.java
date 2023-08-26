package ru.job4j.io.search;

import java.io.*;
import java.nio.file.Path;
import java.util.List;

public class SearchApp {

    public static void writeFiles(List<Path> sources, File target) throws IOException {
        try (PrintWriter pw = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(target)))) {
            sources.forEach(pw::println);
        }
    }

    public static void main(String[] args) throws IOException {
        Validator valid = Validator.getValidator();
        valid.init();
        List<Path> sources = Search.search(Path.of(valid.getValue("d")), valid.getValue("n"));
        writeFiles(sources, Path.of(valid.getValue("o")).toFile());
    }
}
