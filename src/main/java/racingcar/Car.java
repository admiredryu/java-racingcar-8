package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        String n = name.trim();
        if (n.isEmpty() || n.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1~5자여야 합니다.");
        }
        this.name = n;
    }

    public void moveIf(boolean canMove) {
        if (canMove) position++;
    }

    public String getName() { return name; }
    public int getPosition() { return position; }
}
