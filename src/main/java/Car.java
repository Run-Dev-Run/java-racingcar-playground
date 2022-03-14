import java.util.Objects;

public class Car {

    public final int MOVE_PERMISSION_MIN_NUMBER = 4;

    private final Name name;
    private final Position position;

    public Car(Name name, Position position) {
        validate(name, position);
        this.name = name;
        this.position = position;
    }

    private void validate(Name name, Position position) {
        if (Objects.isNull(name) || Objects.isNull(position)) {
            throw new IllegalArgumentException("Name and Position must be not null");
        }
    }

    public void move(RandomNumber randomNumber) {
        if (randomNumber.isMoreThan(MOVE_PERMISSION_MIN_NUMBER)) {
            position.moveOneStep();
        }
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
