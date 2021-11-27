package utils;

import baseball.DTO.ScoreData;

import java.util.ArrayList;
import java.util.Collections;
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

    public boolean askUserRestartGame(int yesInt, int noInt) {
        boolean boolVariable = false;
        String userInput = askForIntegerInput();

        if (!isValidDigits(userInput, 1)) {
            throw new IllegalArgumentException();
        }

        int userIntegerInput = Integer.parseInt(userInput);

        if (userIntegerInput != yesInt && userIntegerInput != noInt) {
            throw new IllegalArgumentException();
        }

        if (userIntegerInput == yesInt) {
            boolVariable = true;
        }

        if (userIntegerInput == noInt) {
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
        for (int i = 0; i < size; i++) {
            try {
                int guess = askUniqueInteger(1, 9, guesses);
                guesses.add(guess);
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

    private boolean isInteger(String input) {
        return input.chars().allMatch(Character::isDigit);
    }

    private boolean isValidDigits(String stringIntegerInput, int digitSize) {
        return digitSize == stringIntegerInput.length();
    }

    private int isValidRange(int inclusive_lb, int inclusive_ub) {

    }
}
