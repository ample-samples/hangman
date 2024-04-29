package org.example.userInteraction;

import org.example.gameState.State;

import java.util.Locale;
import java.util.Scanner;

public class Commands {
    private Scanner scanner = new Scanner(System.in);
    private String name;
    private String[] commands;
    private State state;

    public Commands(State state) {
        this.state = state;
    }

    public char getCharInput() {
        String userInput;
        char choice = ' ';
        userInput = scanner.nextLine().toLowerCase();
        boolean validChoice = isValidInput(userInput);
        if (validChoice) {
            choice = userInput.charAt(0);
        }
        return choice;
    }

    private boolean isValidInput(String userInput) {
        boolean isValid = false;
        if (userInput.length() != 1 || !Character.isLetter(userInput.charAt(0))) {
            System.out.println("This is not valid choice, please try again");
        } else {
            isValid = true;
        }

        return isValid;
    }
}
