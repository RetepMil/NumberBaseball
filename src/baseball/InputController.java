package baseball;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputController {
    final private static Scanner SCANNER = new Scanner(System.in);

    public InputController(){}

    public static boolean askIfContinue() {
        boolean shouldContinue = false;
        int input = SCANNER.nextInt();

        if (input == 1) {
            shouldContinue = true;
        }

        if (input != 2) {
            throw new IllegalArgumentException();
        }

        return shouldContinue;
    }

    public static int getGuessInput() throws Exception {
        int input = SCANNER.nextInt();

        if (input > 9) {
            throw new IllegalArgumentException();
        }

        if (input < 0) {
            throw new IllegalArgumentException();
        }

        return input;
    }
}
