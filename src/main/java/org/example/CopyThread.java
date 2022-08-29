package org.example;

import java.io.File;
import java.nio.file.Files;
import java.util.Scanner;

public class CopyThread extends Thread {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String source;
        String destination;

        System.out.println("Enter the path to the directory where the file is located:");
        source = scanner.next();

        File scrDir = new File(source);

        System.out.println("Enter a new path to copy the file to:");
        destination = scanner.next();

        File destDir = new File(destination);

        try {
           Files.copy(scrDir.toPath(), destDir.toPath());
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("The file has been copied.");
    }
}
