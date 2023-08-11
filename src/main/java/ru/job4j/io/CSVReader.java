package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.*;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        List<String> lines = new ArrayList<>();
        List<Integer> columns = new ArrayList<>();
        Path path = Path.of(argsName.get("path"));
        String delimiter = argsName.get("delimiter");
        String[] filter = argsName.get("filter").split(",");
        if (!(path.toFile().getPath().endsWith(".csv"))) {
            throw new IllegalArgumentException(String.format("File '%s' is not '.csv'", path));
        }
        try (Scanner scanner = new Scanner(path)) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String col: filter) {
            if (col != null) {
                int num = (int) Arrays.stream(lines.get(0).split(delimiter)).takeWhile(a -> !(a.equals(col))).count();
                columns.add(num);
            }
        }
        if ("stdout".equals(argsName.get("out"))) {
            out(lines, columns, delimiter).forEach(System.out::println);
        } else {
            try (PrintWriter pw = new PrintWriter(new FileWriter(argsName.get("out"), true))) {
                out(lines, columns, delimiter).forEach(pw::println);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static List<String> out(List<String> lines, List<Integer> columns, String delimiter) {
        StringJoiner sj = new StringJoiner(delimiter);
        List<String> rsl = new ArrayList<>();
        for (String line: lines) {
            for (Integer col: columns) {
                sj.add(Arrays.stream(line.split(delimiter)).skip(col).findFirst().orElseThrow());
            }
            rsl.add(sj.toString());
            sj = new StringJoiner(delimiter);
        }
        return rsl;
    }

    public static void main(String[] args) throws Exception {
        ArgsName argsName = ArgsName.of(args);
        handle(argsName);
    }
}
