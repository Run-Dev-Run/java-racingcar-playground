import java.util.Random;

public class RandomNumber {

    public final int MIN_RANDOM_NUMBER = 0;
    public final int MAX_RANDOM_NUMBER = 9;
    private final int number;

    public RandomNumber() {
        this.number = generate();
    }

    public RandomNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < MIN_RANDOM_NUMBER || number > MAX_RANDOM_NUMBER) {
            throw new IllegalArgumentException("RandomNumber는 " + MIN_RANDOM_NUMBER + " 보다 크고 " + MAX_RANDOM_NUMBER + "보다 작아야 합니다.");
        }
    }

    private int generate() {
        return new Random().nextInt(MAX_RANDOM_NUMBER);
    }

    public boolean isMoreThan(int comparisonNumber) {
        return comparisonNumber <= number;
    }

    public boolean isLessThan(int comparisonNumber) {
        return comparisonNumber >= number;
    }

}
