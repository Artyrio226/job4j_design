package ru.job4j.cache;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DirFileCache extends AbstractCache<String, String> {
    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) throws IOException {
        File dir = new File(cachingDir);
        List<File> files = Arrays.stream(dir.listFiles())
                .filter(a -> a.getPath().contains(key))
                .toList();
        if (files.size() == 0) {
            throw new FileNotFoundException();
        }
        String file = files.get(0)
                .toString();
        String value;
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            value = in.lines().collect(Collectors.joining(System.lineSeparator()));
        }
        return value;
    }
}