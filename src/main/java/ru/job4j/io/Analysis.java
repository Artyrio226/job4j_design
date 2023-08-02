package ru.job4j.io;

import java.io.*;
import java.util.List;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             BufferedWriter out = new BufferedWriter(new FileWriter(target))) {
            List<String> list = in.lines().toList();
            boolean off = true;
            for (String l: list) {
                Object[] tmp = l.split(" ");
                String k = tmp[0].toString();
                String v = tmp[1].toString();
                if (("400".equals(k) || "500".equals(k)) && off) {
                    off = false;
                    out.write(v + ";");
                }
                if (("200".equals(k) || "300".equals(k)) && !off) {
                    off = true;
                    out.write(v + ";" + System.lineSeparator());
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
