package org.example.gameState;

import org.example.userInteraction.Display;
import org.example.userInteraction.Commands;

import java.util.HashSet;

// Logic will have methods which allow interaction with the game
// e.g. `.makeGuess(char guess)` `.gameStart()` `.restart()`
public class Logic {
    private boolean gameOver = false;
    private int livesLeft = 3;
    Display display = new Display();
    State state = new State();
    Commands commands = new Commands(state);
    String[] allWords = new String[]{
            "television",
            "calf",
            "office",
            "list",
            "plug",
            "anxiety",
            "recognize",
            "guerrilla",
            "partner",
            "steward",
            "activity",
            "lily",
            "sunshine",
            "letter",
            "solo",
            "trouser",
            "rocket",
            "float",
            "poison",
            "designer"
    };

    public void startGame() {
        while (!gameOver) {
            // show disguised word
            display.displayHangedMan(state.getGameWord(), state.getGuesses());
            // ask for guess
            char guess = commands.getCharInput();
            // validate guess
            boolean validGuess = guess != ' ';
            if (!validGuess) {
                System.out.println("You lost a life");
                livesLeft--;
            } else {
                boolean successfulGuess = state.addToGuessSet(guess);
                if (!successfulGuess) {
                    System.out.println("You lost a life");
                    livesLeft--;
                }
            }
            // check lives left
            gameOver = gameOver || isGameOver(livesLeft);
            gameOver = gameOver || isWordGuessed(state.getGameWord(), state.getGuesses());
        }

    }

    private boolean isWordGuessed(String gameWord, HashSet<Character> guesses) {
        boolean allCharactersGuessed = true;
        for (int i = 0; i < gameWord.length(); i++) {
            allCharactersGuessed = guesses.contains(gameWord.charAt(i)) && allCharactersGuessed;
        }
        if (allCharactersGuessed) {
            System.out.println("You win!");
        }
        return allCharactersGuessed;
    }

    private boolean isGameOver(int livesLeft) {
        boolean gameLost = livesLeft <= 0;
        if (gameLost) {
            System.out.println("You lose");
        }
        return gameLost;
    }
}
