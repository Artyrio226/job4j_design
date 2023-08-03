package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             BufferedWriter out = new BufferedWriter(new FileWriter(target))) {
            boolean off = true;
            while (in.ready()) {
                String[] s = in.readLine().split(" ");
                boolean status = "400".equals(s[0]) || "500".equals(s[0]);
                if (status == off) {
                    out.append(s[1])
                            .append(";")
                            .append(off
                                    ? ""
                                    : System.lineSeparator());
                    off = !off;
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
