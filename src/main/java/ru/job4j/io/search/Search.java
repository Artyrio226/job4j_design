package ru.job4j.io.search;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class Search {
    public static List<Path> search(Path root, String file) throws IOException {
        Predicate<Path> condition = getPredicate(file);
        SearchFile searcher = new SearchFile(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    private static Predicate<Path> getPredicate(String file) {
        Validator valid = Validator.getValidator();
        String type = valid.getValue("t");
        return switch (type) {
            case "mask" -> a -> FileSystems.getDefault()
                    .getPathMatcher("glob:" + file)
                    .matches(a.getFileName());
            case "regex" -> a -> Pattern.compile(file)
                    .matcher(a.toFile().getName())
                    .matches();
            default -> a -> a.toFile()
                    .getName()
                    .endsWith(file);
        };
    }
}
