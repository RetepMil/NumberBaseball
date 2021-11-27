package baseball;

import baseball.DTO.ScoreData;
import baseball.DTO.TargetNumber;
import utils.UserInputController;

import java.util.ArrayList;

public class Game {
    private final UserInputController userInputController;
    private final TargetNumber targetNumbers;
    private final int size;

    public Game() {
        this.userInputController = new UserInputController();
        this.targetNumbers = new TargetNumber();
        this.size = 3;
    }

    public void startGame() {
        do {
            gameProcess();
        } while (this.userInputController.askIntergetToBoolean(1, 2));
        System.out.println("게임이 완전히 종료되었습니다.");
    }

    private void gameProcess() {
        boolean willContinue = true;
        while (willContinue) {
            ArrayList<Integer> userInputs = userInputController.getUserInput(this.size);
            ScoreData scoreData = calculateScore(userInputs);
            System.out.println(scoreData.getHintString());
            willContinue = !scoreData.isWin(this.size);
        }

        System.out.println(this.size + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private ScoreData calculateScore(ArrayList<Integer> userInputs) {
        ScoreData scoreData = new ScoreData(0, 0);
        for (int i = 0; i < this.size; i++) {
            final int currentPlaceAnswer = this.targetNumbers.getTargetNumber(i);
            if (userInputs.get(i) == currentPlaceAnswer) {
                scoreData.setStrike(scoreData.getStrike() + 1);
            } else if (this.targetNumbers.getAllTargetNumbers()
                    .stream()
                    .filter(n -> n == userInputs.get(i))
                    .count()
                    == 1) {
                scoreData.setBall(scoreData.getBall() + 1);
            }
        }
        return scoreData;
    }
}
