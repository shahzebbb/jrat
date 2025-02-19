package com.vcs.commands;

import com.vcs.core.Repository;

public class InitCommand {
    
    public static void execute() {
        Repository.initialize();
    }
}
