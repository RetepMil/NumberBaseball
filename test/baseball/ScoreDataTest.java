package baseball;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ScoreDataTest {
    int strike = 3;
    int ball = 4;
    ScoreData scoreData = new ScoreData(strike, ball);

    @Test
    @DisplayName("스트라이크 개수를 정확하게 가져오는지")
    void getStrike() {
        Assertions.assertEquals(scoreData.getStrike(), strike);
    }

    @Test
    @DisplayName("볼 개수를 정확하게 가져오는지")
    void getBall() {
        Assertions.assertEquals(scoreData.getBall(), ball);
    }

    @Test
    @DisplayName("스트라이크 개수를 정확하게 반영하는지")
    void setStrike() {
        int testInteger = 5;
        ScoreData scoreDataTest = new ScoreData(strike, ball);
        scoreDataTest.setStrike(testInteger);
        Assertions.assertEquals(scoreDataTest.getStrike(), testInteger);
    }

    @Test
    @DisplayName("볼 개수를 정확하게 반영하는지")
    void setBall() {
        int testInteger = 5;
        ScoreData scoreDataTest = new ScoreData(strike, ball);
        scoreDataTest.setBall(testInteger);
        Assertions.assertEquals(scoreDataTest.getBall(), testInteger);
    }

    @Test
    @DisplayName("현재 점수에 대한 힌트를 제대로 출력하는지")
    void getHintString() {
        String expectedString = "4볼 3스트라이크 ";
        Assertions.assertEquals(scoreData.getHintString(), expectedString);
    }

    @Test
    @DisplayName("Winning Condition을 제대로 판단하는지")
    void isWin() {
        Assertions.assertTrue(scoreData.isWin(3));
        Assertions.assertFalse(scoreData.isWin(4));
    }
}