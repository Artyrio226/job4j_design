package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             BufferedWriter out = new BufferedWriter(new FileWriter(target))) {
            boolean off = false;
            while (in.ready()) {
                String[] s = in.readLine().split(" ");
                String k = s[0];
                String v = s[1];
                if (("400".equals(k) || "500".equals(k)) && !off) {
                    out.append(v).append(";");
                    off = true;
                }
                if (("200".equals(k) || "300".equals(k)) && off) {
                    out.append(v).append(";").append(System.lineSeparator());
                    off = false;
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
