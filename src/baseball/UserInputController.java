package baseball;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInputController {
    final private static Scanner SCANNER = new Scanner(System.in);

    public UserInputController(){}

    public static boolean askIntergetToBoolean(int yes_int, int no_int) {
        boolean shouldContinue = false;
        int input = SCANNER.nextInt();

        if (input == yes_int) {
            shouldContinue = true;
        }

        if (input == no_int) {
            shouldContinue = false;
        }

        if (input != yes_int && input != no_int) {
            throw new IllegalArgumentException();
        }

        return shouldContinue;
    }

    public static int askInteger(int inclusive_lb, int inclusive_ub, ArrayList<Integer> arr) throws Exception {
        int input = SCANNER.nextInt();

        if (input > inclusive_ub) {
            throw new IllegalArgumentException();
        }

        if (input < inclusive_lb) {
            throw new IllegalArgumentException();
        }

        if (arr.stream().filter(a -> a == input).count() != 0) {
            throw new IllegalArgumentException();
        }

        return input;
    }
}
