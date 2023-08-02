package ru.job4j.io;

import java.io.*;
import java.util.List;
import java.util.StringJoiner;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             BufferedWriter out = new BufferedWriter(new FileWriter(target))) {
            List<String> list = in.lines().toList();
            StringJoiner sj = new StringJoiner(";");
            for (String l: list) {
                Object[] tmp = l.split(" ");
                String k = tmp[0].toString();
                String v = tmp[1].toString();
                if (("400".equals(k) || "500".equals(k)) && sj.length() == 0) {
                    sj.add(v);
                }
                if (("200".equals(k) || "300".equals(k)) && sj.length() != 0) {
                    sj.add(v);
                    out.write(sj + ";" + System.lineSeparator());
                    sj = new StringJoiner(";");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}
