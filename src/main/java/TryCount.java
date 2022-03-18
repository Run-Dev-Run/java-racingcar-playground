public class TryCount {

    private final String TRY_COUNT_INVALID_MESSAGE = "Try 횟수는 1 이상만 입력이 가능합니다.";
    private final int MIN_TRY_COUNT = 0;

    private final int count;

    public TryCount(int count) {
        validate(count);
        this.count = count;
    }

    private void validate(int count) {
        if (count <= MIN_TRY_COUNT) {
            throw new IllegalArgumentException(TRY_COUNT_INVALID_MESSAGE);
        }
    }

    public void startTryUpToTryCount(Cars cars) {
        for (int i = 0; i < count; i++) {
            cars.move();
        }
    }

}
