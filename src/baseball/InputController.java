package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputController {
    final private static Scanner SCANNER = new Scanner(System.in);
    private static Exception IllegalArgumentException = new Exception("0~9 범위의 숫자 세개를 넣어주세요");

    public InputController(){}

    public static boolean inputContinue() {
        boolean input = false;
        try {
            input = SCANNER.nextBoolean();
        } catch (InputMismatchException e) {
            System.out.println("비정상적 입력입니다");
        }
        return input;
    }

    public static int inputGuessInteger() throws Exception {
        int input;
        input = SCANNER.nextInt();

        if (input > 9)
            throw
        return 1;
    }
}
