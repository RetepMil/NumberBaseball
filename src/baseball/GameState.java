package baseball;

import utils.RandomUtils;

import java.util.ArrayList;

public class GameState {
    private ArrayList<Integer> targetNumbers = new ArrayList<Integer>();
    private int strike;;
    private int ball;

    public GameState() {
        for (int i = 0; i < 3; i++) {
            int num = RandomUtils.nextInt(1, 9);
            this.targetNumbers.add(num);
            if (this.targetNumbers.stream().distinct().count() == i) { // 중복된 숫자 선택 방지
                this.targetNumbers.remove(i--);
            }
        }
    }

    public void newGuess(int guess, int order) {
        if (guess == this.targetNumbers.get(order)) { //Check for strike condition
            this.strike++;
        } else if (this.targetNumbers.stream().filter(n -> n == guess).count() == 1) { //Check for ball condition
            this.ball++;
        }
    }

    public boolean isWin() {
        //Check for winning Condition
        if (this.strike == 3) {
            return true;
        }

        printHint();
        resetBallStrikeStates();
        return false;
    }

    private void printHint() {
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike > 0) {
            System.out.print(strike + "스트라이크 ");
        }
        System.out.println();
    }

    private void resetBallStrikeStates() {
        this.strike = 0;
        this.ball = 0;
    }
}
