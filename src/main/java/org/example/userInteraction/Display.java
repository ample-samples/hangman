package org.example.userInteraction;

import java.util.HashSet;

public class Display {
    public void displayHangedMan(String gameWord, HashSet<Character> guessedChars ) {
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
