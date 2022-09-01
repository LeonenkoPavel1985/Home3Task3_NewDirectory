package org.example;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);

        String existingPath;
        String newPath;

        System.out.println("Enter the path to an existing directory:");
        existingPath = scanner.next();

        System.out.println("Enter a new directory path:");
        newPath = scanner.next();
        scanner.close();

        CopyThread copyThread = new CopyThread(existingPath,newPath);
        copyThread.start();
        copyThread.join();

        System.out.println("The copy operation has ended.");
    }
}