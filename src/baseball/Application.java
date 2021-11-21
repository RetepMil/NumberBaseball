package baseball;

public class Application {
    public static void main(String[] args) {
        boolean willContinue = true;
        while(willContinue) {
            Game game = new Game();
            game.startGame();
            //game = null 해줘야 하나요?
            willContinue = InputController.askIfContinue();
        }
        System.out.println("게임이 완전히 종료되었습니다.");
    }
}