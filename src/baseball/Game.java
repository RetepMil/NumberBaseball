package baseball;


import utils.RandomUtils;

import java.util.ArrayList;

public class Game {
    GameState gameState;

    public Game() {
        this.gameState = new GameState();
    }

    public void startGame() {
        //Repeat asking process
        do {
            askForGuesses();
        } while (!gameState.isWin());
    }

    private void askForGuesses() {
        ArrayList<Integer> guessHistory = new ArrayList<Integer>(); //for duplicate checking
        System.out.print("숫자를 입력해주세요 (1~9 범위의 숫자 3개): ");
        for (int i = 0; i < 3; i++) {
            try {
                int guess = UserInputController.askUniqueInteger(1, 9, guessHistory);
                guessHistory.add(guess);
                gameState.newGuess(guess, i);
            } catch (IllegalArgumentException e) {
                System.out.print("비정상적인 입력");
                System.exit(0);
            } catch (Exception e) {
                System.out.print(e.getMessage());
                System.exit(0);
            }
        }
    }
}
