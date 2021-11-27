package utils;

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

    public boolean askUserRestartGame() {
        boolean boolVariable = false;
        String userInput = askForIntegerInput();

        if (!isValidDigits(userInput, 1)) {
            throw new IllegalArgumentException();
        }

        int userIntegerInput = Integer.parseInt(userInput);

        if (userIntegerInput != 1 && userIntegerInput != 2) {
            throw new IllegalArgumentException();
        }

        if (userIntegerInput == 1) {
            boolVariable = true;
        }

        if (userIntegerInput == 2) {
            boolVariable = false;
        }

        return boolVariable;
    }

    public ArrayList<Integer> askUserGuessInput(int size) {
        System.out.print("숫자를 입력해주세요 (1~9 범위의 숫자"+ size + "개): ");
        String userInput = askForIntegerInput();
        if (!isValidDigits(userInput, size)) {
            throw new IllegalArgumentException();
        }
        ArrayList<Integer> guesses = userInput.chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toCollection(ArrayList::new));
        for (Integer guess : guesses) {
            if (!isValidRange(1, 9, guess) || !isNotDuplicate(guess, guesses)) {
                throw new IllegalArgumentException();
            }
        }
        return guesses;
    }

    private boolean isInteger(String input) {
        return input.chars().allMatch(Character::isDigit);
    }

    private boolean isValidDigits(String stringIntegerInput, int digitSize) {
        return digitSize == stringIntegerInput.length();
    }

    private boolean isValidRange(int inclusive_lb, int inclusive_ub, int integer) {
        return integer >= 1 && integer <= 9;
    }

    private boolean isNotDuplicate(int integer, ArrayList<Integer> integerList) {
        return integerList.stream().filter(i -> i == integer).count() == 1;
    }
}
