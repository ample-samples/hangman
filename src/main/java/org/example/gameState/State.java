package org.example.gameState;

import java.util.ArrayList;
import java.util.HashSet;

// State will have methods for saving and retrieving information relevant to the game
public class State {
    private HashSet<Character> guesses = new HashSet<>();
    private String gameWord;

    public State(String gameWord) {
        this.gameWord = gameWord;
    }

    public boolean addToGuessSet(char character) {
        if (gameWord.indexOf(character) != -1) {
            guesses.add(character);
            return true;
        } else {
            return false;
        }
    }

    public String getGameWord() {
        return gameWord;
    }

    public HashSet<Character> getGuesses() {
        return guesses;
    }
}
