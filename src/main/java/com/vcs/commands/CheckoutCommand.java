package com.vcs.commands;

import com.vcs.core.Repository;

    public class CheckoutCommand {
        public static void execute(String commitId) {
            Repository.checkout(commitId);
        }
}
