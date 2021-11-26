package baseball;

import java.util.ArrayList;

public class Game {
    GameState gameState;
    UserInputController userInput;

    public Game() {
        this.gameState = new GameState();
        this.userInput = new UserInputController();
    }

    public void startGame() {
        do {
            //Repeat asking process
            gameProcess();
        } while (UserInputController.askIntergetToBoolean(1, 2));
        System.out.println("게임이 완전히 종료되었습니다.");
    }

    private void gameProcess() {
        do {
            askForGuesses();
        } while (!gameState.isWin());
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
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
