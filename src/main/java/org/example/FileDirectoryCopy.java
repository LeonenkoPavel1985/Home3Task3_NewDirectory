package org.example;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileDirectoryCopy extends Thread {
    private File source;
    private File destination;

    public FileDirectoryCopy(File source, File destination) {
        this.source = source;
        this.destination = destination;
    }

    @Override
    public void run() {

    }

    private void CopyFile(File file, Path path) {
        try {
            Files.copy(file.toPath(), new File(path + File.separator + file.getName()).toPath());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void CopyDirectory(File source, File destination) {
        File t = new File(destination, source.getName());
        t.mkdir(); // метод создает каталог.
        File[] files = source.listFiles();

        if (files != null) {
            try {
                for (File f : files) {
                    if (f.isFile()) CopyFile(f, t.toPath());
                    else CopyDirectory(f, t);
                }
            } catch (Exception e) {
                new RuntimeException(e);
            }
        }
    }

}
