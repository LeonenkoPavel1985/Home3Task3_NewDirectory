package org.example;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CopyThread copyThread = new CopyThread();
        copyThread.run();
    }
}