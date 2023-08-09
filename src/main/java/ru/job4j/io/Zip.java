package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(target))) {
            for (Path path : sources) {
                zip.putNextEntry(new ZipEntry(path.toFile().getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(path.toFile()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void validate(ArgsName arg) {
        Path directory = Path.of(arg.get("d"));
        String exclude = arg.get("e");
        String output = arg.get("o");
        if (!directory.toFile().exists()) {
            throw new IllegalArgumentException(String.format("Argument '%s' is not exist", directory.isAbsolute()));
        }
        if (!directory.toFile().isDirectory()) {
            throw new IllegalArgumentException(String.format("Argument '%s' is not directory", directory.isAbsolute()));
        }
        if (!exclude.startsWith(".")) {
            throw new IllegalArgumentException(String.format("Argument '%s' is not extension", exclude));
        }
        if (!output.endsWith(".zip")) {
            throw new IllegalArgumentException(String.format("File '%s' is not '.zip'", output));
        }

    }

    public static void main(String[] args) throws IOException {
        ArgsName ar = ArgsName.of(args);
        Zip zip = new Zip();
        zip.validate(ar);
        String exc = ar.get("e");
        List<Path> sources = Search.search(Path.of(ar.get("d")), exc);
        File o = new File(ar.get("o"));
        zip.packFiles(sources, o);
        zip.packSingleFile(
                new File("./pom.xml"),
                new File("./pom.zip")
        );
    }
}
