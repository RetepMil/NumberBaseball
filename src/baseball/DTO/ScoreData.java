package baseball.DTO;

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

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }
}
