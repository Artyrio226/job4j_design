package ru.job4j.io;

import java.io.FileOutputStream;
import java.util.StringJoiner;

public class ResultFile {
    public static void main(String[] args) {
        var sj = new StringJoiner(" ");
        try (FileOutputStream out = new FileOutputStream("data/dataresult.txt")) {
            for (int i = 1; i <= 9; i++) {
                for (int j = 1; j <= 9; j++) {
                    int sum = i * j;
                    if (sum > 9) {
                        sj.add(String.valueOf(sum));
                    } else {
                        sj.add(" " + sum);
                    }
                }
                out.write(sj.toString().getBytes());
                out.write(System.lineSeparator().getBytes());
                sj = new StringJoiner(" ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
