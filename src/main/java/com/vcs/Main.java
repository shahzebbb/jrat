package com.vcs;

import java.util.Scanner;

import com.vcs.commands.*;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please input a command.");
            return;
        }

        switch (args[0]) {
            case "init":
                InitCommand.execute();
                break;
            case "commit":
                if (args.length != 2){
                    System.out.println("Please attach a commit message.");
                    return;
                }
                CommitCommand.execute(args[1]);
                break;
            case "log":
                LogCommand.execute();
                break;
            case "checkout":
                if (args.length != 2){
                    System.out.println("Please attach a commit id.");
                    return;
                }
                System.out.println("Are you sure you wish to do this? Uncommited work will be overriden. (yes/no)");
                // Prompt the user for confirmation
                Scanner scanner = new Scanner(System.in);
                String response = scanner.nextLine().trim().toLowerCase();

                // Check if the response is 'yes'
                if (response.equals("yes") || response.equals("y")) {
                    System.out.println("Proceeding with the action...");
                    // Add your logic here to proceed
                } else {
                    System.out.println("Operation cancelled.");
                    return;
                }
                
                CheckoutCommand.execute(args[1]);
        }

    }
}