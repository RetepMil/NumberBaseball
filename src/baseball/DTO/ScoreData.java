package baseball;

public class ScoreData {
    private int strike;
    private int ball;

    public ScoreData() {}

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
}
