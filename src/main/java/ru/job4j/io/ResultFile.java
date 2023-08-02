package ru.job4j.io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringJoiner;

public class ResultFile {
    public static void main(String[] args) {
        var sj = new StringJoiner(" ");
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream("data/result.txt")
                ))) {
            for (int i = 1; i <= 9; i++) {
                for (int j = 1; j <= 9; j++) {
                    int sum = i * j;
                    if (sum > 9) {
                        sj.add(String.valueOf(sum));
                    } else {
                        sj.add(" " + sum);
                    }
                }
                out.println(sj);
                sj = new StringJoiner(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
