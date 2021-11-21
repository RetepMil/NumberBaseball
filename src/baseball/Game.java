package baseball;


import utils.RandomUtils;

import java.util.ArrayList;

public class Game {
    private ArrayList<Integer> targetNumbers = new ArrayList<Integer>();

    public Game() {
        for (int i = 0; i < 3; i++) {
            int num = RandomUtils.nextInt(0, 10);
            this.targetNumbers.add(num);
            if (this.targetNumbers.stream().distinct().count() == i) {
                i--;
                this.targetNumbers.remove(i);
            }
        }
    }

    public void startGame() {
        while (true) {
            System.out.print("숫자를 입력해주세요: ");
            ArrayList<Integer> guesses = new ArrayList<Integer>();
            guesses.add(InputController.inputGuessInteger());
            guesses.add(InputController.inputGuessInteger());
            guesses.add(InputController.inputGuessInteger());
        }
    }

    private void checkNumbers() {}
}
