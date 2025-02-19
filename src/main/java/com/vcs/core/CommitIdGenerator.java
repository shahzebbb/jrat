package com.vcs.core;

import java.util.UUID;


public class CommitIdGenerator {
    public static String generateID() {
        UUID commitId = UUID.randomUUID();
        return commitId.toString();
    }
}
