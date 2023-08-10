package ru.job4j.regex;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> log = new ArrayList<>();
        boolean bot = true;
        try (Scanner sc = new Scanner(System.in)) {
            while (sc.hasNext()) {
                String text = sc.nextLine();
                log.add(text);
                if (OUT.equals(text)) {
                    saveLog(log);
                    break;
                }
                if (bot) {
                        if (STOP.equals(text)) {
                            bot = false;
                        } else {
                            answer(log);
                        }
                }
                if (!bot && CONTINUE.equals(text)) {
                    answer(log);
                    bot = true;
                }
                saveLog(log);
                log = new ArrayList<>();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void answer(List<String> log) {
        String s = readPhrases().get(0);
        System.out.println(s);
        log.add(s);
    }

    private List<String> readPhrases() {
        List<String> rsl = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(botAnswers, StandardCharsets.UTF_8))) {
            List<String> list = br.lines().toList();
            int randomIndex = (int) (Math.random() * list.size());
            rsl.add(list.get(randomIndex));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, StandardCharsets.UTF_8, true))) {
            log.forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("./data/log1.txt", "./data/answers.txt");
        cc.run();
    }
}