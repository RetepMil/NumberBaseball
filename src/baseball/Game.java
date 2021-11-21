package baseball;


import utils.RandomUtils;

import java.util.ArrayList;

public class Game {
    private ArrayList<Integer> targetNumbers = new ArrayList<Integer>();

    public Game() {
        for (int i = 0; i < 3; i++) {
            int num = RandomUtils.nextInt(0, 9);
            this.targetNumbers.add(num);
            if (this.targetNumbers.stream().distinct().count() == i) { // 중복된 숫자 선택 방지
                this.targetNumbers.remove(i--);
            }
        }
    }

    public void startGame() {
        //Repeat asking process
        while (checkGuesses(askForGuesses()));

        //Exit when winning condition is met
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private ArrayList<Integer> askForGuesses() {
        ArrayList<Integer> guesses = new ArrayList<Integer>();
        System.out.print("숫자를 입력해주세요: ");
        for (int i = 0; i < 3; i++) {
            try {
                guesses.add(InputController.getGuessInput());
            } catch (IllegalArgumentException e) {
                System.out.print("비정상적인 입력");
                System.exit(0);
            } catch (Exception e) {
                System.out.print(e.getMessage());
                System.exit(0);
            }
        }
        return guesses;
    }

    private boolean checkGuesses(ArrayList<Integer> guesses) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            int guess = guesses.get(i);
            if (guess == this.targetNumbers.get(i)) { //Check for strike condition
                strike++;
            } else if (this.targetNumbers.stream().filter(n -> n == guess).count() == 1) { //Check for ball condition
                ball++;
            }
            //else nothing
        }

        //Check for winning Condition
        if (strike == 3) {
            return false;
        }

        //Give feedback
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike > 0) {
            System.out.print(strike + "스트라이크 ");
        }
        System.out.println();

        return true;
    }
}
