import java.util.Objects;

public class Car {

    private final Name name;
    private Position position;
    private final MoveStrategy strategy;

    public Car(String name, int position, MoveStrategy strategy) {
        this(name, strategy);
        this.position = new Position(position);
    }

    public Car(String name, MoveStrategy strategy) {
        validateMoveStrategy(strategy);
        this.name = new Name(name);
        this.position = new Position();
        this.strategy = strategy;
    }

    private void validateMoveStrategy(MoveStrategy strategy) {
        if (Objects.isNull(strategy)) {
            throw new IllegalArgumentException("MoveStrategy must be not null");
        }
    }

    public void move() {
        this.position = strategy.move(this.position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

}
