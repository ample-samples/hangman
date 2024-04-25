package org.example.userInteraction;

import java.util.Scanner;

public class Commands {
    private Scanner scanner = new Scanner(System.in);
    private String name;
    private String[] commands;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getCommands() {
        return commands;
    }

    public void setCommands(String[] commands) {
        this.commands = commands;
    }

    public void printGreeting() {
        System.out.println(String.format("Welcome to the %s commands", name));
    }

    public void printCommands() {
        if (commands == null || commands.length == 0) {
            System.out.println("No current commands set");
        } else {
            System.out.println("Please select an option");
            for (int i = 0; i < commands.length; i++) {
                System.out.printf("%s: %s\n", i, commands[i]);
            }
            getIntegerInput();
        }
    }

    private int getIntegerInput() {
        int choice = -1;
        while (choice >= commands.length || choice < 0) {
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                choice = -1;
            }
            scanner.nextLine();
            if (choice >= commands.length || choice < 0) {
                System.out.println("This is not valid choice, please try again");
            }
        }
        System.out.println("you chose: " + commands[choice]);
        return choice;
    }

    public void getStringInput() {

    }
}
