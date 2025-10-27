package racingcar;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGame {
    private final InputView input;
    private final ResultView output;
    private final RandomMoveStrategy strategy;

    public RacingGame(InputView input, ResultView output, RandomMoveStrategy strategy) {
        this.input = input;
        this.output = output;
        this.strategy = strategy;
    }

    public void run() {
        List<Car> cars = parseCars(input.readNames());
        int tries = input.readTryCount();
        System.out.println("실행 결과");
        for (int i = 0; i < tries; i++) {
            raceOnce(cars);
            output.printRound(cars);
        }
        output.printWinners(findWinners(cars));
    }

    private List<Car> parseCars(String line) {
        String[] tokens = line.split(",");
        List<Car> list = new ArrayList<>();
        for (String t : tokens) list.add(new Car(t));
        return list;
    }

    private void raceOnce(List<Car> cars) {
        for (Car c : cars) c.moveIf(strategy.canMove());
    }

    private List<String> findWinners(List<Car> cars) {
        int max = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        return cars.stream()
                .filter(c -> c.getPosition() == max)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
