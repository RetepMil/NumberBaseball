package baseball;

public class Application {
    public static void main(String[] args) {
        boolean willContinue = true;
        while(willContinue) {
            willContinue = false;

            Game game = new Game();
            game.startGame();
            game = null;

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            willContinue = InputController.inputContinue();
        }
        System.out.println("게임이 종료되었습니다.");
    }
}