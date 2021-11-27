package baseball;

public class ScoreData {
    private int strike;
    private int ball;

    public ScoreData (int strike, int ball) {
        this.ball = ball;
        this.strike = strike;
    }

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public String getHintString() {
        String hintString = "";
        if (ball > 0) {
            hintString += ball + "볼 ";
        }
        if (strike > 0) {
            hintString += strike + "스트라이크 ";
        }
        if (ball == 0 && strike == 0)
            hintString += "낫싱";

        return hintString;
    }

    public boolean isWin(int size) {
        return this.strike == size;
    }
}
