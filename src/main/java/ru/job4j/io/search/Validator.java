package ru.job4j.io.search;

import java.io.Console;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Validator {
    private final Map<String, String> values = new HashMap<>();
    private static final Validator INSTANCE = new Validator();

    private Validator() {
    }

    public static Validator getValidator() {
        return INSTANCE;
    }

    public void init() {
        String params;
        Console console = System.console();
        if (console == null) {
            System.out.println("The console is unavailable");
            return;
        }
        boolean run = true;
        while (run) {
            params = console.readLine("%s", "Enter the parameters: ");
            if (!parse(params)) {
                continue;
            }
            if (!validate(values)) {
                continue;
            }
            run = !run;
        }
    }



    public String getValue(String key) {
        return values.get(key);
    }

    private boolean parse(String line) {
        boolean rsl = true;
        String[] args = line.split(" ");
        if (args.length < 4) {
            System.out.printf("Need more arguments%n");
            rsl = false;
        } else {
            for (String s : args) {
                if (!s.contains("=")) {
                    System.out.printf("Error: This argument '%s' does not contain an equal sign%n", s);
                    rsl = false;
                    break;
                }
                if (!s.startsWith("-")) {
                    System.out.printf("Error: This argument '%s' does not start with a '-' character%n", s);
                    rsl = false;
                    break;
                }
                String[] split = s.split("=", 2);
                String key = split[0].substring(1);
                if (key.length() == 0) {
                    System.out.printf("Error: This argument '%s' does not contain a key%n", s);
                    rsl = false;
                    break;
                }
                if (split[1].length() == 0) {
                    System.out.printf("Error: This argument '%s' does not contain a value%n", s);
                    rsl = false;
                    break;
                }
                values.put(key, split[1]);
            }
        }
        return rsl;
    }

    private boolean validate(Map<String, String> values) {
        boolean rsl = true;
        Path directory = Path.of(values.get("d"));
        String name = values.get("n");
        String type = values.get("t");
        String output = values.get("o");
        if (!directory.toFile().exists()) {
            System.out.printf("Argument '%s' is not exist%n", directory);
            rsl = false;
        } else if (!directory.toFile().isDirectory()) {
            System.out.printf("Argument '%s' is not a directory%n", directory);
            rsl = false;
        } else if (!output.contains(".")) {
            System.out.printf("Argument '%s' is not a file%n", output);
            rsl = false;
        } else if (!name.contains(".")) {
            System.out.printf("Argument '%s' is not a file%n", name);
            rsl = false;
        } else if (!type.contains("mask") && !type.contains("name") && !type.contains("regex")) {
            System.out.printf("Argument '%s' must be \"mask\", \"name\" or \"regex\"%n", type);
            rsl = false;
        }
        return rsl;
    }
}
