package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException(String.format("This key: '%s' is missing", key));
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        for (String s: args) {
            if (!s.contains("=")) {
                throw new IllegalArgumentException(
                        String.format("Error: This argument '%s' does not contain an equal sign", s));
            }
            if (!s.startsWith("-")) {
                throw new IllegalArgumentException(
                        String.format("Error: This argument '%s' does not start with a '-' character", s));
            }
            String[] split = s.split("=", 2);
            String key = split[0].substring(1);
            if (key.length() == 0) {
                throw new IllegalArgumentException(
                        String.format("Error: This argument '%s' does not contain a key", s));
            }
            if (split[1].length() == 0) {
                throw new IllegalArgumentException(
                        String.format("Error: This argument '%s' does not contain a value", s));
            }
            values.put(key, split[1]);
        }
    }

    public static ArgsName of(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Arguments not passed to program");
        }
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}