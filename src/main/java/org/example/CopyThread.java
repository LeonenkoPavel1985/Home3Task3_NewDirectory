package org.example;

import java.io.File;
import java.nio.file.Files;
import java.util.Scanner;

import static java.nio.file.Files.copy;

public class CopyThread extends Thread {
    private File source;
    private  File destination;

    public CopyThread (String existingPath, String newPath) {
        this.source = new  File(existingPath);
        this.destination = new File(newPath);
    }
    @Override
    public void run() {
        File[] files = source.listFiles();
        System.out.println(files.length);
        if (files != null)
            for (File f : files){
                FileDirectoryCopy copy = new FileDirectoryCopy(f, destination);
                copy.start();
                System.out.println("Start.");
            }
    }
}
