public class RandomNumber extends AbstractNumber {

    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

    private final int max;

    private final int min;

    public RandomNumber(int number) {
        super(number);
        this.max = MAX_RANDOM_NUMBER;
        this.min = MIN_RANDOM_NUMBER;
        validate(number);
    }

    private void validate(int number) {
        if (number < min || number > max) {
            throw new IllegalArgumentException("RandomNumber는 " + min + " 보다 크고 " + max + "보다 작아야 합니다.");
        }
    }

}
