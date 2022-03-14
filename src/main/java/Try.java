public class Try {

    public static final String TRY_COUNT_INVALID_MESSAGE = "Try 횟수는 1 이상만 입력이 가능합니다.";
    private final int count;

    public Try(int count) {
        validate(count);
        this.count = count;
    }

    private void validate(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException(TRY_COUNT_INVALID_MESSAGE);
        }
    }

}
