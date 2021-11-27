package baseball;

import utils.RandomUtils;
import utils.UserInputController;

import java.util.ArrayList;

public class Game {
    private final UserInputController userInputController;
    private final int size;
    private final ArrayList<Integer> targetNumbers;

    public Game() {
        final int size = 3;
        this.userInputController = new UserInputController();
        this.size = size;
        this.targetNumbers = initializeTargetNumbers(size);
    }

    public Game(int size) {
        this.userInputController = new UserInputController();
        this.size = size;
        this.targetNumbers = initializeTargetNumbers(size);
    }

    private ArrayList<Integer> initializeTargetNumbers(int size) {
        ArrayList<Integer> numArr = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) {
            int num = RandomUtils.nextInt(1, 9);
            numArr.add(num);
            if (numArr.stream().distinct().count() == i) { // 중복된 숫자 선택 방지
                numArr.remove(i--);
            }
        }
        return numArr;
    }

    private ScoreData calculateScore(ArrayList<Integer> guesses) {
        ScoreData scoreData = new ScoreData(0, 0);
        for (int i = 0; i < this.size; i++) {
            int currentPlaceGuess = guesses.get(i);
            int currentPlaceTargetNumber = this.targetNumbers.get(i);

            if (currentPlaceGuess == currentPlaceTargetNumber) {
                scoreData.setStrike(scoreData.getStrike() + 1);
                continue;
            }
            if (this.targetNumbers.stream().filter(x -> x == currentPlaceGuess).count() != 0) {
                scoreData.setBall(scoreData.getBall() + 1);
            }
        }
        return scoreData;
    }

    private void gameProcess() {
        boolean willContinue = true;
        while (willContinue) {
            ArrayList<Integer> userInputs = userInputController.askUserGuessInput(this.size);
            ScoreData scoreData = calculateScore(userInputs);
            System.out.println(scoreData.getHintString());
            willContinue = !scoreData.isWin(this.size);
        }

        System.out.println(this.size + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void startGame() {
        try {
            do {
                gameProcess();
            } while (this.userInputController.askUserRestartGame());
            System.out.println("게임이 완전히 종료되었습니다.");
        } catch (IllegalArgumentException e) {
            System.err.println("비정상적인 입력");
            System.exit(0);
        }
    }
}
