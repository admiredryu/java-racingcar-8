package racingcar;

public class Application {
    public static void main(String[] args) {
        new RacingGame(
                new InputView(),
                new ResultView(),
                new RandomMoveStrategy()
        ).run();
    }
}
