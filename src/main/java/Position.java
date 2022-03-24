import java.util.Objects;

public class Position {

    private static final int DEFAULT_STEP_COUNT = 0;

    private final int step;

    public Position() {
        this.step = DEFAULT_STEP_COUNT;
    }

    public Position(int step) {
        validate(step);
        this.step = step;
    }

    private void validate(int step) {
        if (step < DEFAULT_STEP_COUNT) {
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
        return Objects.hash(DEFAULT_STEP_COUNT, step);
    }

}
