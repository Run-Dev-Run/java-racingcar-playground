import java.util.Objects;

public class Position {

    private final int ZERO = 0;

    private final int step;

    public Position() {
        this.step = ZERO;
    }

    public Position(int step) {
        validate(step);
        this.step = step;
    }

    private void validate(int step) {
        if (step < ZERO) {
            throw new IllegalArgumentException("step에 음수를 입력할 수 없습니다.");
        }
    }

    public Position moveOneStep() {
        return new Position(step + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position1 = (Position) o;
        return step == position1.step;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ZERO, step);
    }

}
