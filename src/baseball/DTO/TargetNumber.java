package baseball.DTO;

import utils.RandomUtils;

import java.util.ArrayList;

public class TargetNumber {
    private final ArrayList<Integer> targetNumbers;

    public TargetNumber() {
        this.targetNumbers = initializeAnswer();
    }

    private ArrayList<Integer> initializeAnswer() {
        ArrayList<Integer> numArr = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) {
            int num = RandomUtils.nextInt(1, 9);
            this.targetNumbers.add(num);
            if (this.targetNumbers.stream().distinct().count() == i) { // 중복된 숫자 선택 방지
                this.targetNumbers.remove(i--);
            }
        }
        return numArr;
    }

    public ArrayList<Integer> getAllTargetNumbers() {
        return this.targetNumbers;
    }

    public int getTargetNumber(int index) {
        return targetNumbers.get(index);
    }
}
