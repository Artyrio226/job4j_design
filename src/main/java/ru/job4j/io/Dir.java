package ru.job4j.io;

import java.io.File;

public class Dir {
    public void fileInfo(File file) {
        System.out.println(String.format("name : %s, size : %d", file.getName(), fileSize(file)));
    }
    private long fileSize(File file) {
        long sum = 0;
        if (!file.isDirectory()) {
            sum = sum + file.length();
        }
        return sum;
    }
    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is null. Usage  ROOT_FOLDER.");
        }
        File file = new File(args[0]);
        File file1 = new File("C:\\projects\\job4j_design\\src\\main\\java\\ru\\job4j\\io\\Config.java");
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        System.out.println(String.format("size : %s", file.getTotalSpace()));
        for (File subfile : file.listFiles()) {
            System.out.println(subfile.getAbsoluteFile());
        }
        Dir dir = new Dir();
        dir.fileInfo(file);
        dir.fileInfo(file1);
    }
}
