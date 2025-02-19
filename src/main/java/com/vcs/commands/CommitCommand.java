package com.vcs.commands;

import com.vcs.core.Repository;

public class CommitCommand {
    
    public static void execute(String commitMesssge) {
        Repository.commit(commitMesssge);
    }
}
