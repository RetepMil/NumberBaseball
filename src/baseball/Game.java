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
        //Repeat asking process
        while (checkGuesses(askForGuesses()));
        //Exit when winning condition is met
    }

    private ArrayList<Integer> askForGuesses() {
        ArrayList<Integer> guesses = new ArrayList<Integer>();
        System.out.print("숫자를 입력해주세요: ");
        for (int i = 0; i < 3; i++) {
            try {
                guesses.add(InputController.getGuessInput());
            } catch (IllegalArgumentException e) {
                System.out.print("비정상적 입력 감지");
            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
        }
        return guesses;
    }

    private boolean checkGuesses(ArrayList<Integer> guesses) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            int guess = guesses.get(i);
            if (guess == this.targetNumbers.get(i))
                strike++;
            if (this.targetNumbers.stream().filter(n -> n == guess).count() == 1)
                ball++;
        }

        //Check for winning Condition
        if (strike == 3)
            return false;

        //Give feedback
        if (ball > 0)
            System.out.print(ball + "볼 ");
        if (strike > 0)
            System.out.print(ball + "볼 ");
        System.out.println("");

        return true;
    }
}
