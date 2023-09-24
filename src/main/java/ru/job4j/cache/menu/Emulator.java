package ru.job4j.cache.menu;

import ru.job4j.cache.DirFileCache;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.Stream;

public class Emulator {
    private static final String FIRST_MENU = "Укажите директорию:";
    public static final String SECOND_MENU = """
                Введите 1, чтобы загрузить содержимое файла в кэш.
                Введите 2, чтобы получить содержимое файла.
                Введите любое другое число для выхода.
            """;
    private static final String FILE = "Укажите имя файла: ";
    private String dir = "";

    private boolean validate(String str) {
        boolean rsl = true;
        boolean ext;
        try (Stream<Path> stream = Files.list(Path.of(dir))) {
            ext = stream.map(Path::toString).anyMatch(a -> a.endsWith(str));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (!str.endsWith(".txt")) {
            System.out.println("Формат файла должен быть .txt");
            rsl = false;
        } else if (!ext) {
            System.out.println("Такого файла нет");
            rsl = false;
        }
        return rsl;
    }

    public void run() {
        boolean first = true;
        Scanner sc = new Scanner(System.in);
        while (first) {
            System.out.println(FIRST_MENU);
            dir = sc.nextLine();
            if (!Files.exists(Path.of(dir))) {
                System.out.println("Такой дирректории не существует. Попробуйте снова." + System.lineSeparator());
                continue;
            }
            boolean second = true;
            while (second) {
                System.out.println(SECOND_MENU);
                String rsl = sc.nextLine();
                if (!rsl.chars().allMatch(Character::isDigit)) {
                    System.out.println("Неверный аргумент." + System.lineSeparator());
                    continue;
                }
                int choice = Integer.parseInt(rsl);
                boolean third = true;
                if (choice == 1) {
                    while (third) {
                        System.out.println(FILE);
                        String text = sc.nextLine();
                        if (validate(text)) {
                            String key = dir.concat("/").concat(text);
                            DirFileCache dfc = new DirFileCache(dir);
                            String value = dfc.get(key);
                            dfc.put(key, value);
                            System.out.println("Содержимое файла загружено в кэш." + System.lineSeparator());
                            third = false;
                        }
                    }
                }
                if (choice == 2) {
                    while (third) {
                        System.out.println(FILE);
                        String text = sc.nextLine();
                        if (!validate(text)) {
                            String key = dir.concat("/").concat(text);
                            DirFileCache dfc = new DirFileCache(dir);
                            System.out.println(dfc.get(key));
                            third = false;
                        }
                    }
                }
                if (choice < 1 || choice > 2) {
                    second = false;
                }
            }
            first = false;
            System.out.println("Конец работы");
        }
    }

    public static void main(String[] args) {
        Emulator em = new Emulator();
        em.run();
    }
}
