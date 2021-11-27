package utils;

import baseball.DTO.ScoreData;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserInputController {
    final private Scanner SCANNER = new Scanner(System.in);

    public UserInputController(){}

    private String askForIntegerInput() {
        String input = SCANNER.nextLine();
        if (isInteger(input)) {
            return input;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public boolean askUserRestartGame(int yes_int, int no_int) {
        boolean boolVariable = false;
        int userInput = Integer.parseInt(askForIntegerInput());

        if (userInput == yes_int) {
            boolVariable = true;
        }

        if (userInput == no_int) {
            boolVariable = false;
        }

        if (userInput != yes_int && userInput != no_int) {
            throw new IllegalArgumentException();
        }

        return boolVariable;
    }

    public int askUniqueInteger(int inclusive_lb, int inclusive_ub, ArrayList<Integer> history) {
        int userInput = Integer.parseInt(askForIntegerInput());

        if (userInput > inclusive_ub) {
            throw new IllegalArgumentException();
        }

        if (userInput < inclusive_lb) {
            throw new IllegalArgumentException();
        }

        if (history.stream().filter(a -> a == userInput).count() != 0) {
            throw new IllegalArgumentException();
        }

        return userInput;
    }

    public ArrayList<Integer> askUserGuessInput(int size) {
        ArrayList<Integer> guessHistory = new ArrayList<Integer>(); //for duplicate checking
        System.out.print("숫자를 입력해주세요 (1~9 범위의 숫자"+ size + "개): ");
        for (int i = 0; i < size; i++) {
            try {
                int guess = askUniqueInteger(1, 9, guessHistory);
                guessHistory.add(guess);
            } catch (IllegalArgumentException e) {
                System.out.print("비정상적인 입력");
                System.exit(0);
            } catch (Exception e) {
                System.out.print(e.getMessage());
                System.exit(0);
            }
        }
        return guessHistory;
    }

    private boolean isInteger(String input) {
        return input.chars().allMatch(Character::isDigit);
    }

    private checkForDuplicatedNumber(int numberInput) {

    }
}
