package com.vcs.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {
    private static final File logsFile = new File(".vcs/logs.txt");

    public static void appendToLog(String commitId, String commitMessage, File logsFile) {
        // Message to append
        LocalDateTime now = LocalDateTime.now();

        String message = "date_time: " + now + "\n" +
                         "commit_id: " + commitId + "\n" +
                         "commit_message: " + commitMessage + "\n" +
                         "\n\n";

        // Append message to logs.txt
        try (FileWriter writer = new FileWriter(logsFile.getPath(), true)) {
            writer.write(message);
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }

    }

    public static void printLog() {
        if (logsFile.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(logsFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.err.println("Error reading the file: " + e.getMessage());
            }
        } else {
            System.out.println("The log file does not exist. Please run init command to create the log file.");
        }
    }
}
