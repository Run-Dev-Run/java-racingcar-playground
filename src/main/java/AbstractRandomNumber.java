public abstract class AbstractRandomNumber {

    private final int number;

    private final int max;

    private final int min;

    public AbstractRandomNumber(int number, int max, int min) {
        this.max = max;
        this.min = min;
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < min || number > max) {
            throw new IllegalArgumentException("RandomNumber는 " + min + " 보다 크고 " + max + "보다 작아야 합니다.");
        }
    }

    public boolean isMoreThan(int comparisonNumber) {
        return comparisonNumber <= number;
    }

    public boolean isLessThan(int comparisonNumber) {
        return comparisonNumber >= number;
    }

}
