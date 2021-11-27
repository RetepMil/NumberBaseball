package utils;

import baseball.DTO.ScoreData;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInputController {
    final private Scanner SCANNER = new Scanner(System.in);

    public UserInputController(){}

    public boolean askIntergetToBoolean(int yes_int, int no_int) {
        boolean boolVariable = false;
        int input = SCANNER.nextInt();

        if (input == yes_int) {
            boolVariable = true;
        }

        if (input == no_int) {
            boolVariable = false;
        }

        if (input != yes_int && input != no_int) {
            throw new IllegalArgumentException();
        }

        return boolVariable;
    }

    public int askUniqueInteger(int inclusive_lb, int inclusive_ub, ArrayList<Integer> history) throws Exception {
        int input = SCANNER.nextInt();

        if (input > inclusive_ub) {
            throw new IllegalArgumentException();
        }

        if (input < inclusive_lb) {
            throw new IllegalArgumentException();
        }

        if (history.stream().filter(a -> a == input).count() != 0) {
            throw new IllegalArgumentException();
        }

        return input;
    }

    public ScoreData getUserInput(ScoreData scoreData, int size) {
        ArrayList<Integer> guessHistory = new ArrayList<Integer>(); //for duplicate checking
        System.out.print("숫자를 입력해주세요 (1~9 범위의 숫자"+ size + "개): ");
        for (int i = 0; i < size; i++) {
            try {
                int guess = UserInputController.askUniqueInteger(1, 9, guessHistory);
                guessHistory.add(guess);
                calculateScore(guess, i, scoreData);
            } catch (IllegalArgumentException e) {
                System.out.print("비정상적인 입력");
                System.exit(0);
            } catch (Exception e) {
                System.out.print(e.getMessage());
                System.exit(0);
            }
        }
        return scoreData;
    }
}
