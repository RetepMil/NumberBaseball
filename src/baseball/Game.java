package baseball;

import baseball.DTO.ScoreData;
import baseball.DTO.TargetNumber;
import utils.UserInputController;

public class Game {
    private final UserInputController userInput;
    private final TargetNumber targetNumbers;
    private final int size;

    public Game() {
        this.userInput = new UserInputController();
        this.targetNumbers = new TargetNumber();
        this.size = 3;
    }

    public void startGame() {
        do {
            gameProcess();
        } while (this.userInput.askIntergetToBoolean(1, 2));
        System.out.println("게임이 완전히 종료되었습니다.");
    }

    private void gameProcess() {
        boolean willContinue = false;
        while (willContinue) {
            ScoreData newScoreData = new ScoreData(0, 0);
            printHint(userInput.getUserInput(newScoreData, this.size));
            willContinue = !isWin(newScoreData);
        }

        System.out.println(this.size + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private void calculateScore(int guess, int order, ScoreData scoreData) {
        if (guess == this.targetNumbers.getTargetNumber(order)) { //Check for strike condition
            scoreData.setStrike(scoreData.getStrike() + 1);
        } else if (this.targetNumbers.getAllTargetNumbers().stream().filter(n -> n == guess).count() == 1) { //Check for ball condition
            scoreData.setBall(scoreData.getBall() + 1);
        }
    }

    private void printHint(ScoreData scoreData) {
        int ball = scoreData.getBall();
        int strike = scoreData.getStrike();
        
        if (ball == 0 && strike == 0)
            System.out.print("낫싱");
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike > 0) {
            System.out.print(strike + "스트라이크 ");
        }
        System.out.println();
    }

    private boolean isWin(ScoreData scoreData) {
        //Check for winning Condition
        if (scoreData.getStrike() == this.size) {
            return true;
        }
        return false;
    }
}
