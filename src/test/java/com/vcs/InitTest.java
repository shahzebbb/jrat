package com.vcs;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InitTest {
    private Path vcsDir = Paths.get(".vcs");
    private Path commitDir = Paths.get(".vcs/commits");
    private Path logsFile = Paths.get(".vcs/logs.txt");

    @BeforeEach
    void setup() throws IOException {
        if (Files.exists(vcsDir)) { // Prevent exception if .vcs doesn't exist
            Files.walk(vcsDir)
                 .sorted((a, b) -> b.compareTo(a)) // Delete files before directories
                 .forEach(p -> p.toFile().delete());
        }
    }

    @AfterEach
    void tearDown() throws IOException {
        if (Files.exists(vcsDir)) { // Prevent exception if .vcs doesn't exist
            Files.walk(vcsDir)
                 .sorted((a, b) -> b.compareTo(a)) // Delete files before directories
                 .forEach(p -> p.toFile().delete());
        }
    }

    @Test
    void testInit() throws IOException {
        String[] args = {"init"};
        Main.main(args);

        assertTrue(Files.exists(vcsDir), ".vcs directory should be created");
        assertTrue(Files.exists(commitDir), ".vcs/commits directory should be created");
        assertTrue(Files.exists(logsFile), ".vcs/logs.txt file should be created");
    }
}
