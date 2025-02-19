package com.vcs.core;
import java.io.File;

public class Repository {
    private static final File hiddenFolder = new File(".vcs");
    private static final File commitFolder = new File(".vcs/commits");
    private static final File logsFile = new File(".vcs/logs.txt");

    public static void initialize() {

        if (!hiddenFolder.exists()){
            boolean created = hiddenFolder.mkdirs();

            if (created) {
                commitFolder.mkdirs();
                try {
                    logsFile.createNewFile();
                } catch (Exception e) {
                    System.err.println("Failed to create: " + logsFile.getName());
                }

                System.out.println("Repository initalized in " + hiddenFolder.getAbsolutePath());
            } else {
                System.out.println("There was a problem initializing this repository.");
            }

        } else if (!commitFolder.exists() || !logsFile.exists()){

            if (!commitFolder.exists()){
                commitFolder.mkdirs();
            }
            
            if (!logsFile.exists()){
                try {
                    logsFile.createNewFile();
                } catch (Exception e) {
                    System.err.println("Failed to create: " + logsFile.getName());
                }
            }
            
            System.out.println("Repository initalized in " + hiddenFolder.getAbsolutePath());
        } else {
            System.out.println("This repository has already been initialized");
        }
    }

    public static void commit(String commitMessage) {
        if (hiddenFolder.exists()){
            String commitId = CommitIdGenerator.generateID();
            File newCommitFolder = new File(commitFolder, commitId);

            newCommitFolder.mkdirs();
            Copier.copyFoldersToCommit(newCommitFolder);

            Logger.appendToLog(commitId, commitMessage, logsFile);
        } else {
            System.out.println("Error: No repository found. Plese run 'init' first.");
        }
    }

    public static void checkout(String commitId) {
        File checkoutFolder = new File(commitFolder, commitId);
        if (checkoutFolder.exists()){
            Copier.checkoutCommit(checkoutFolder);
        } else {
            System.out.println("This commit does not exist. Please run log to see the available commits and their corresponding ids.");
        }
    }
}
