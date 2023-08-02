package ru.job4j.io;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class LogFilter {
    private final String file;

    public LogFilter(String file) {
        this.file = file;
    }

    public List<String> filter() {
        List<String> rsl = null;
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            rsl = in.lines().filter(a -> {
                Object[] tmp = Arrays.stream(a.split(" ")).toArray();
                return "404".equals(tmp[tmp.length - 2]);
            }).toList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    public void saveTo(String out) {
        var data = filter();
        try (PrintWriter pw = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(out)
                ))) {
            data.forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new LogFilter("data/log.txt").saveTo("data/404.txt");
    }
}
