package ru.job4j.cache.menu;

import ru.job4j.cache.DirFileCache;

import java.io.IOException;
import java.util.Scanner;

public class Emulator {
    private static final String FIRST_MENU = "Укажите директорию.";
    public static final String SECOND_MENU = "Введите имя файла для загрузки или exit для выхода.";

    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println(FIRST_MENU);
        String dir = sc.nextLine();
        DirFileCache dfc = new DirFileCache(dir);
        System.out.println(SECOND_MENU);
        String rsl = sc.nextLine();
        while (!"exit".equals(rsl)) {
            try {
                System.out.println(dfc.get(rsl));
            } catch (IOException e) {
                System.out.println("Такой файл не найден.");
            }
            rsl = sc.nextLine();
        }
        System.out.println("Конец работы");
    }

    public static void main(String[] args) {
        Emulator em = new Emulator();
        em.run();
    }
}
