package org.example.userInteraction;

import java.util.HashSet;

public class Display {
    public void displayHangedMan(String gameWord, HashSet<Character> guessedChars, int livesLeft) {

        String[] hangedMan = new String[]{
                          "",
                          "       \n"
                        + "       \n"
                        + "       \n"
                        + "       \n"
                        + "       \n"
                        + "       \n"
                        + "=========",
                          "  +---+\n"
                        + "  |   |\n"
                        + "      |\n"
                        + "      |\n"
                        + "      |\n"
                        + "      |\n"
                        + "=========",
                          "  +---+\n"
                        + "  |   |\n"
                        + "  O   |\n"
                        + " /|\\  |\n"
                        + " / \\  |\n"
                        + "      |\n"
                        + "=========",
        };
        System.out.println(hangedMan[Math.min(3, 3 - livesLeft)]);

        String disguisedWord = "";

        for (int i = 0; i < gameWord.length(); i++) {
            if (guessedChars.contains(gameWord.charAt(i))) {
                disguisedWord += gameWord.charAt(i) + " ";
            } else {
                disguisedWord += "_ ";
            }
        }

        System.out.println(disguisedWord);
    }
}
