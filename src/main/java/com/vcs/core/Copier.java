package com.vcs.core;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Copier {
    public static void copyFoldersToCommit(File newCommitFolder) {
        File currentDir = newCommitFolder.getAbsoluteFile().getParentFile().getParentFile().getParentFile();

        File[] subdirectories = currentDir.listFiles(file -> file.isDirectory());

        if (subdirectories != null) {
            for (File folder : subdirectories){
                if (folder.getName().equals(".vcs")) {
                    continue;
                }

                File targetDirectory = new File(newCommitFolder, folder.getName());

                try {
                    copyFolder(folder.toPath(), targetDirectory.toPath());
                } catch (IOException e) {
                    System.err.println("Failed to copy: " + folder.getName());
                    e.printStackTrace();
                }
            }
        }
    }

    public static void checkoutCommit(File checkoutFolder) {
        File currentDir = checkoutFolder.getAbsoluteFile().getParentFile().getParentFile().getParentFile();

        File[] subdirectories = checkoutFolder.listFiles(file -> file.isDirectory());

        if (subdirectories != null) {
            for (File folder : subdirectories){

                File targetDirectory = new File(currentDir, folder.getName());

                try {
                    copyFolder(folder.toPath(), targetDirectory.toPath());
                } catch (IOException e) {
                    System.err.println("Failed to copy: " + folder.getName());
                    e.printStackTrace();
                }
            }
        }
    }

    public static void copyFolder(Path source, Path destination) throws IOException {
        Files.walk(source)
            .forEach(sourcePath -> {
                try {
                    Path targetPath = destination.resolve(source.relativize(sourcePath));
                    if (Files.isDirectory(sourcePath)) {
                        Files.createDirectories(targetPath);
                    } else {
                        Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
                    }
                } catch (IOException e) {
                    throw new RuntimeException("Error copying " + sourcePath, e);
                }
            });
    }

}
